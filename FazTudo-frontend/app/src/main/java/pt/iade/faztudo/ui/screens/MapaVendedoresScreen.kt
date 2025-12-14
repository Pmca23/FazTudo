package pt.iade.faztudo.ui.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.VendedorResponse
import pt.iade.faztudo.data.repository.LocationData
import pt.iade.faztudo.data.repository.LocationManager
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapaVendedoresScreen(
    navController: NavController,
    categoriaId: Int,
    sessionManager: SessionManager
) {
    var vendedores by remember { mutableStateOf<List<VendedorResponse>>(emptyList()) }
    var categoriaNome by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }
    var selectedVendedor by remember { mutableStateOf<VendedorResponse?>(null) }
    var currentLocation by remember { mutableStateOf<LocationData?>(null) }
    var isLoadingLocation by remember { mutableStateOf(true) }
    var isLoggedIn by remember { mutableStateOf(false) }
    
    val context = LocalContext.current
    val locationManager = remember { LocationManager(context) }
    val scope = rememberCoroutineScope()
    
    val defaultLocation = LatLng(38.7223, -9.1393)
    
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultLocation, 12f)
    }
    
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                     permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (granted) {
            scope.launch {
                locationManager.getCurrentLocation().collect { location ->
                    currentLocation = location
                    location?.let {
                        cameraPositionState.position = CameraPosition.fromLatLngZoom(
                            LatLng(it.latitude, it.longitude), 13f
                        )
                    }
                    isLoadingLocation = false
                }
            }
        } else {
            isLoadingLocation = false
        }
    }
    
    LaunchedEffect(Unit) {
        sessionManager.isLoggedIn.collect { loggedIn ->
            isLoggedIn = loggedIn
        }
    }
    
    LaunchedEffect(Unit) {
        if (locationManager.hasLocationPermission()) {
            locationManager.getCurrentLocation().collect { location ->
                currentLocation = location
                location?.let {
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(
                        LatLng(it.latitude, it.longitude), 13f
                    )
                }
                isLoadingLocation = false
            }
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }
    
    LaunchedEffect(categoriaId, currentLocation) {
        scope.launch {
            try {
                val catResponse = RetrofitClient.api.getCategoriaById(categoriaId)
                if (catResponse.isSuccessful) {
                    categoriaNome = catResponse.body()?.nome ?: ""
                }
                
                val response = if (currentLocation != null) {
                    RetrofitClient.api.getVendedoresProximos(
                        categoriaId,
                        currentLocation!!.latitude,
                        currentLocation!!.longitude,
                        50.0
                    )
                } else {
                    RetrofitClient.api.getVendedoresByCategoria(categoriaId)
                }
                
                if (response.isSuccessful) {
                    vendedores = response.body() ?: emptyList()
                }
            } catch (e: Exception) { }
            isLoading = false
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isMyLocationEnabled = locationManager.hasLocationPermission()),
            uiSettings = MapUiSettings(zoomControlsEnabled = true, myLocationButtonEnabled = true)
        ) {
            vendedores.forEach { vendedor ->
                vendedor.localizacao?.let { loc ->
                    if (loc.latitude != null && loc.longitude != null) {
                        Marker(
                            state = MarkerState(position = LatLng(loc.latitude, loc.longitude)),
                            title = vendedor.nome,
                            snippet = "${vendedor.mediaAvaliacoes?.let { String.format("%.1f", it) } ?: "N/A"} ⭐",
                            icon = BitmapDescriptorFactory.defaultMarker(
                                if (selectedVendedor?.idVendedor == vendedor.idVendedor)
                                    BitmapDescriptorFactory.HUE_GREEN
                                else
                                    BitmapDescriptorFactory.HUE_AZURE
                            ),
                            onClick = {
                                selectedVendedor = vendedor
                                true
                            }
                        )
                    }
                }
            }
        }
        
        TopAppBar(
            title = { Text(categoriaNome.ifEmpty { "Mapa" }) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
            )
        )
        
        if (isLoading || isLoadingLocation) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        
        selectedVendedor?.let { vendedor ->
            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(vendedor.nome, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            vendedor.localizacao?.cidade?.let { cidade ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.LocationOn, contentDescription = null, modifier = Modifier.size(16.dp), tint = TextGray)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(cidade, style = MaterialTheme.typography.bodySmall, color = TextGray)
                                    vendedor.distanciaKm?.let { dist ->
                                        Text(" • ${String.format("%.1f", dist)} km", style = MaterialTheme.typography.bodySmall, color = PrimaryBlue)
                                    }
                                }
                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = StarYellow, modifier = Modifier.size(20.dp))
                            Text(String.format("%.1f", vendedor.mediaAvaliacoes ?: 0.0), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(
                            onClick = { navController.navigate(Screen.VendedorDetalhe.createRoute(vendedor.idVendedor)) },
                            modifier = Modifier.weight(1f)
                        ) { Text("Ver Detalhes") }
                        
                        Button(
                            onClick = {
                                if (isLoggedIn) {
                                    val vendedorCategoriaId = vendedor.categorias?.find { it.categoria.idCategoria == categoriaId }?.idVendedorCategoria
                                    vendedorCategoriaId?.let { navController.navigate(Screen.ContratarServico.createRoute(it)) }
                                } else {
                                    navController.navigate(Screen.Login.route)
                                }
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                        ) { Text("Contratar") }
                    }
                }
            }
        }
    }
}

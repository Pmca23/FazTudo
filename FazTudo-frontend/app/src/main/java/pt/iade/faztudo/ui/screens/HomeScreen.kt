package pt.iade.faztudo.ui.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.repository.LocationData
import pt.iade.faztudo.data.repository.LocationManager
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var selectedTab by remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    var cityQuery by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }
    var isLoggedIn by remember { mutableStateOf(false) }
    var userName by remember { mutableStateOf<String?>(null) }
    
    // Localização
    var currentLocation by remember { mutableStateOf<LocationData?>(null) }
    var isLoadingLocation by remember { mutableStateOf(false) }
    
    val context = LocalContext.current
    val locationManager = remember { LocationManager(context) }
    val scope = rememberCoroutineScope()
    
    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                     permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (granted) {
            isLoadingLocation = true
            scope.launch {
                locationManager.getCurrentLocation().collect { location ->
                    currentLocation = location
                    location?.cidade?.let { cityQuery = it }
                    isLoadingLocation = false
                }
            }
        }
    }
    
    fun requestLocation() {
        if (locationManager.hasLocationPermission()) {
            isLoadingLocation = true
            scope.launch {
                locationManager.getCurrentLocation().collect { location ->
                    currentLocation = location
                    location?.cidade?.let { cityQuery = it }
                    isLoadingLocation = false
                }
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
    
    LaunchedEffect(Unit) {
        sessionManager.isLoggedIn.collect { loggedIn ->
            isLoggedIn = loggedIn
        }
    }
    
    LaunchedEffect(Unit) {
        sessionManager.userName.collect { name ->
            userName = name
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWhite)
    ) {
        // Top Bar
        TopAppBar(
            title = { },
            navigationIcon = {
                IconButton(onClick = { showMenu = true }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BackgroundWhite
            )
        )
        
        // Menu Drawer
        if (showMenu) {
            AlertDialog(
                onDismissRequest = { showMenu = false },
                title = { Text("Menu") },
                text = {
                    Column {
                        if (isLoggedIn) {
                            Text("Olá, ${userName ?: "Utilizador"}!", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            TextButton(onClick = {
                                showMenu = false
                                navController.navigate(Screen.Perfil.route)
                            }) {
                                Text("Meu Perfil")
                            }
                            
                            TextButton(onClick = {
                                showMenu = false
                                navController.navigate(Screen.MeusServicos.route)
                            }) {
                                Text("Meus Serviços")
                            }
                            
                            TextButton(onClick = {
                                scope.launch {
                                    sessionManager.clearSession()
                                    showMenu = false
                                }
                            }) {
                                Text("Sair", color = ErrorRed)
                            }
                        } else {
                            Text("Aceda à sua conta ou crie uma nova")
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            OutlinedButton(
                                onClick = {
                                    showMenu = false
                                    navController.navigate(Screen.Login.route)
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Login")
                            }
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Button(
                                onClick = {
                                    showMenu = false
                                    navController.navigate(Screen.Register.route)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                            ) {
                                Text("Registar")
                            }
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showMenu = false }) {
                        Text("Fechar")
                    }
                }
            )
        }

        // Tabs
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = BackgroundWhite,
            contentColor = PrimaryBlue
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("Pesquisa") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("Categorias") }
            )
        }

        when (selectedTab) {
            0 -> PesquisaTab(
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                cityQuery = cityQuery,
                onCityChange = { cityQuery = it },
                onSearch = { /* TODO */ },
                currentLocation = currentLocation,
                isLoadingLocation = isLoadingLocation,
                onRequestLocation = { requestLocation() }
            )
            1 -> CategoriasTab(
                navController = navController,
                currentLocation = currentLocation
            )
        }
    }
}

@Composable
fun PesquisaTab(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    cityQuery: String,
    onCityChange: (String) -> Unit,
    onSearch: () -> Unit,
    currentLocation: LocationData?,
    isLoadingLocation: Boolean,
    onRequestLocation: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Encontre o Profissional",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )
        
        Text(
            text = "Perfeito para Si",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = PrimaryBlue
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Ligamos-lhe aos prestadores de serviços mais confiáveis e qualificados. Rápido, seguro e com garantia de qualidade.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextGray,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Search field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = { Text("Que serviço precisa?") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray)
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // mapa com botão de localização
        OutlinedTextField(
            value = cityQuery,
            onValueChange = onCityChange,
            placeholder = { Text("A sua cidade") },
            leadingIcon = { Icon(Icons.Outlined.LocationOn, contentDescription = null) },
            trailingIcon = {
                IconButton(
                    onClick = onRequestLocation,
                    enabled = !isLoadingLocation
                ) {
                    if (isLoadingLocation) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Default.MyLocation, contentDescription = "Usar minha localização", tint = PrimaryBlue)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray)
        )
        
        // Mostrar coordenadas
        currentLocation?.let { location ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "📍 ${String.format("%.4f", location.latitude)}, ${String.format("%.4f", location.longitude)}",
                style = MaterialTheme.typography.labelSmall,
                color = SuccessGreen
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(
            onClick = onSearch,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text("Procurar Agora", fontWeight = FontWeight.SemiBold)
        }
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Stats
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            StatItem(value = "10k+", label = "Prestadores")
            StatItem(value = "50k+", label = "Serviços Realizados")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            StatItem(value = "4.9", label = "Avaliação Média", icon = true)
            StatItem(value = "24h", label = "Suporte")
        }
    }
}

@Composable
fun StatItem(value: String, label: String, icon: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = PrimaryBlue)
            if (icon) {
                Icon(Icons.Outlined.Star, contentDescription = null, tint = StarYellow, modifier = Modifier.size(18.dp))
            }
        }
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = TextGray)
    }
}

@Composable
fun CategoriasTab(navController: NavController, currentLocation: LocationData? = null) {
    val categorias = listOf(
        Triple(1, "Canalizações", "Reparações hidráulicas em geral"),
        Triple(2, "Electricidade", "Instalações e reparações eléctricas"),
        Triple(3, "Limpeza", "Limpeza doméstica e comercial"),
        Triple(4, "Pintura", "Pintura doméstica e comercial"),
        Triple(5, "Jardinagem", "Cuidados com jardins e plantas"),
        Triple(6, "Reparações Gerais", "Serviços de manutenção")
    )


    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        currentLocation?.let { location ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = SuccessGreen.copy(alpha = 0.1f))
            ) {
                Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = SuccessGreen)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "A mostrar prestadores perto de ${location.cidade ?: "si"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = SuccessGreen
                    )
                }
            }
        }
        
        categorias.chunked(2).forEach { row ->
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                row.forEach { (id, nome, descricao) ->
                    CategoriaCard(
                        nome = nome,
                        descricao = descricao,
                        onClickLista = { navController.navigate(Screen.VendedoresByCategoria.createRoute(id)) },
                        onClickMapa = { navController.navigate(Screen.MapaVendedores.createRoute(id)) },
                        modifier = Modifier.weight(1f)
                    )
                }
                if (row.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun CategoriaCard(nome: String, descricao: String, onClickLista: () -> Unit, onClickMapa: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(200.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceGray)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(70.dp).clip(RoundedCornerShape(8.dp)).background(DividerGray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = nome, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold, color = TextDark)
            Text(text = descricao, style = MaterialTheme.typography.bodySmall, color = TextGray, maxLines = 2)
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                OutlinedButton(
                    onClick = onClickLista,
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) { Text("Lista", style = MaterialTheme.typography.labelSmall) }
                Button(
                    onClick = onClickMapa,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) { Text("Mapa", style = MaterialTheme.typography.labelSmall) }
            }
        }
    }
}

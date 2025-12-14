package pt.iade.faztudo.ui.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.RegisterRequest
import pt.iade.faztudo.data.repository.LocationData
import pt.iade.faztudo.data.repository.LocationManager
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telemovel by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var isVendedor by remember { mutableStateOf(false) }
    var aceitaTermos by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    
    // Localização
    var currentLocation by remember { mutableStateOf<LocationData?>(null) }
    var isLoadingLocation by remember { mutableStateOf(false) }
    var cidade by remember { mutableStateOf("") }
    
    val context = LocalContext.current
    val locationManager = remember { LocationManager(context) }
    
    // Categorias selecionadas
    var selectedCategorias by remember { mutableStateOf(setOf<Int>()) }
    
    val categorias = listOf(
        1 to "Limpeza",
        2 to "Canalizações",
        3 to "Electricidade",
        4 to "Pintura",
        5 to "Jardinagem",
        6 to "Reparações Gerais"
    )
    
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    
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
                    location?.cidade?.let { cidade = it }
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
                    location?.cidade?.let { cidade = it }
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp)
    ) {
        // Back button
        Row(
            modifier = Modifier.clickable { navController.popBackStack() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = PrimaryBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Voltar", color = PrimaryBlue)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Title
        Text(
            text = "Criar Conta",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextDark,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Text(
            text = "Registe-se para começar a usar os nossos serviços",
            style = MaterialTheme.typography.bodyMedium,
            color = TextGray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Nome
        Text("Nome Completo", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            placeholder = { Text("João Silva") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Email
        Text("Email", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("seu@email.com") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Telemóvel
        Text("Número de Telemóvel", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = telemovel,
            onValueChange = { telemovel = it },
            placeholder = { Text("+351 912 345 678") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Localização
        Text("Localização", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cidade,
            onValueChange = { cidade = it },
            placeholder = { Text("A sua cidade") },
            leadingIcon = { Icon(Icons.Outlined.LocationOn, contentDescription = null) },
            trailingIcon = {
                IconButton(
                    onClick = { requestLocation() },
                    enabled = !isLoadingLocation
                ) {
                    if (isLoadingLocation) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Default.MyLocation, contentDescription = "Obter localização", tint = PrimaryBlue)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true
        )
        
        // Mostrar coordenadas se tiver localização
        currentLocation?.let { location ->
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = SuccessGreen.copy(alpha = 0.1f))
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = SuccessGreen, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Localização obtida com sucesso!",
                            style = MaterialTheme.typography.labelMedium,
                            color = SuccessGreen
                        )
                        Text(
                            text = "Lat: ${String.format("%.4f", location.latitude)}, Lon: ${String.format("%.4f", location.longitude)}",
                            style = MaterialTheme.typography.labelSmall,
                            color = TextGray
                        )
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Password
        Text("Palavra-passe", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("••••••••") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null
                    )
                }
            }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Confirm Password
        Text("Confirmar Palavra-passe", style = MaterialTheme.typography.labelLarge, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = { Text("••••••••") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = DividerGray),
            singleLine = true,
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        if (confirmPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null
                    )
                }
            }
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Vendedor toggle
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceGray)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Registar como Prestador de Serviços", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Medium)
                    Text("Ofereça os seus serviços profissionais", style = MaterialTheme.typography.bodySmall, color = TextGray)
                }
                Switch(
                    checked = isVendedor,
                    onCheckedChange = { isVendedor = it },
                    colors = SwitchDefaults.colors(checkedTrackColor = PrimaryBlue)
                )
            }
        }
        
        // Categorias (se for vendedor)
        if (isVendedor) {
            Spacer(modifier = Modifier.height(16.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceGray)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Selecione os serviços que presta:", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    categorias.forEach { (id, catNome) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedCategorias = if (selectedCategorias.contains(id)) {
                                        selectedCategorias - id
                                    } else {
                                        selectedCategorias + id
                                    }
                                }
                                .padding(vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = selectedCategorias.contains(id),
                                onCheckedChange = { checked ->
                                    selectedCategorias = if (checked) selectedCategorias + id else selectedCategorias - id
                                },
                                colors = CheckboxDefaults.colors(checkedColor = PrimaryBlue)
                            )
                            Text(catNome, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Termos
        Row(
            modifier = Modifier.clickable { aceitaTermos = !aceitaTermos },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = aceitaTermos,
                onCheckedChange = { aceitaTermos = it },
                colors = CheckboxDefaults.colors(checkedColor = PrimaryBlue)
            )
            Text("Aceito os ", style = MaterialTheme.typography.bodySmall)
            Text("termos e condições", style = MaterialTheme.typography.bodySmall, color = PrimaryBlue)
            Text(" e a ", style = MaterialTheme.typography.bodySmall)
            Text("política de privacidade", style = MaterialTheme.typography.bodySmall, color = PrimaryBlue)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Error message
        errorMessage?.let {
            Text(text = it, color = ErrorRed, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(bottom = 16.dp))
        }
        
        // Register button
        Button(
            onClick = {
                if (password != confirmPassword) {
                    errorMessage = "As palavras-passe não coincidem"
                    return@Button
                }
                
                scope.launch {
                    isLoading = true
                    errorMessage = null
                    try {
                        val response = RetrofitClient.api.register(
                            RegisterRequest(
                                nome = nome,
                                email = email,
                                palavraPasse = password,
                                telemovel = telemovel.ifBlank { null },
                                cidade = cidade.ifBlank { null },
                                latitude = currentLocation?.latitude,
                                longitude = currentLocation?.longitude,
                                registarComoVendedor = isVendedor,
                                categorias = if (isVendedor) selectedCategorias.toList() else null
                            )
                        )
                        if (response.isSuccessful) {
                            response.body()?.let { auth ->
                                sessionManager.saveSession(
                                    token = auth.token,
                                    userId = auth.idUser,
                                    userName = auth.nome,
                                    userEmail = auth.email,
                                    isVendedor = auth.isVendedor,
                                    vendedorId = auth.idVendedor
                                )
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Home.route) { inclusive = true }
                                }
                            }
                        } else {
                            errorMessage = "Erro ao criar conta. O email pode já estar registado."
                        }
                    } catch (e: Exception) {
                        errorMessage = "Erro de ligação. Verifique a sua internet."
                    }
                    isLoading = false
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            enabled = !isLoading && nome.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank() && aceitaTermos
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp), color = MaterialTheme.colorScheme.onPrimary)
            } else {
                Text("Criar Conta", fontWeight = FontWeight.SemiBold)
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Login link
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Já tem uma conta? ", style = MaterialTheme.typography.bodyMedium, color = TextGray)
            Text(
                text = "Entrar",
                style = MaterialTheme.typography.bodyMedium,
                color = PrimaryBlue,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable { navController.navigate(Screen.Login.route) }
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

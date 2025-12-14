package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.LoginRequest
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        // butâo para trás
        Row(
            modifier = Modifier.clickable { navController.popBackStack() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Voltar",
                tint = PrimaryBlue
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Voltar", color = PrimaryBlue)
        }
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Titulo
        Text(
            text = "Bem-vindo de Volta",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = TextDark,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Text(
            text = "Aceda à sua conta para continuar",
            style = MaterialTheme.typography.bodyMedium,
            color = TextGray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(40.dp))
        
        // Email field
        Text(
            text = "Email",
            style = MaterialTheme.typography.labelLarge,
            color = TextDark
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("seu@email.com") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = DividerGray
            ),
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        // Password field
        Text(
            text = "Palavra-passe",
            style = MaterialTheme.typography.labelLarge,
            color = TextDark
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("••••••••") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = DividerGray
            ),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = if (passwordVisible) "Esconder" else "Mostrar"
                    )
                }
            }
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Text(
            text = "Esqueceu a palavra-passe?",
            style = MaterialTheme.typography.bodySmall,
            color = PrimaryBlue,
            modifier = Modifier.align(Alignment.End)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Mensagem de erro
        errorMessage?.let {
            Text(
                text = it,
                color = ErrorRed,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        // Login button
        Button(
            onClick = {
                scope.launch {
                    isLoading = true
                    errorMessage = null
                    try {
                        val response = RetrofitClient.api.login(
                            LoginRequest(email, password)
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
                            errorMessage = "Email ou palavra-passe incorretos"
                        }
                    } catch (e: Exception) {
                        errorMessage = "Erro de ligação. Verifique a sua internet."
                    }
                    isLoading = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            enabled = !isLoading && email.isNotBlank() && password.isNotBlank()
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Entrar", fontWeight = FontWeight.SemiBold)
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Register link
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Não tem uma conta? ",
                style = MaterialTheme.typography.bodyMedium,
                color = TextGray
            )
            Text(
                text = "Registe-se",
                style = MaterialTheme.typography.bodyMedium,
                color = PrimaryBlue,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Register.route)
                }
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

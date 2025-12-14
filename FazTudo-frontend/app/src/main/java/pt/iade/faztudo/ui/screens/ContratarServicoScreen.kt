package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.ServicoRequest
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContratarServicoScreen(
    navController: NavController,
    vendedorCategoriaId: Int,
    sessionManager: SessionManager
) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Contratar Serviço") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            }
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceGray)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Preencha os detalhes do serviço que pretende contratar",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextGray
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text("Título do Serviço *", style = MaterialTheme.typography.labelLarge, color = TextDark)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                placeholder = { Text("Ex: Reparação de torneira") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text("Descrição", style = MaterialTheme.typography.labelLarge, color = TextDark)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                placeholder = { Text("Descreva o serviço que precisa...") },
                modifier = Modifier.fillMaxWidth().height(120.dp),
                shape = RoundedCornerShape(12.dp),
                maxLines = 5
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text("Preço proposto (€) *", style = MaterialTheme.typography.labelLarge, color = TextDark)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = preco,
                onValueChange = { if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*$"))) preco = it },
                placeholder = { Text("Ex: 50.00") },
                leadingIcon = { Text("€", style = MaterialTheme.typography.bodyLarge) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = WarningYellow.copy(alpha = 0.1f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("⚠️ Informação", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold, color = WarningYellow)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("O serviço ficará pendente até o prestador aceitar.", style = MaterialTheme.typography.bodySmall, color = TextGray)
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            errorMessage?.let {
                Text(text = it, color = ErrorRed, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(bottom = 16.dp))
            }
            
            Button(
                onClick = {
                    val precoValue = preco.toDoubleOrNull()
                    if (precoValue == null || precoValue <= 0) {
                        errorMessage = "Insira um preço válido"
                        return@Button
                    }
                    
                    scope.launch {
                        isLoading = true
                        errorMessage = null
                        try {
                            val token = sessionManager.getAuthHeader().firstOrNull()
                            if (token != null) {
                                val response = RetrofitClient.api.criarServico(
                                    token,
                                    ServicoRequest(titulo = titulo, descricao = descricao.ifBlank { null }, preco = precoValue, idVendedorCategoria = vendedorCategoriaId)
                                )
                                if (response.isSuccessful) {
                                    response.body()?.let { servico ->
                                        navController.navigate(Screen.ServicoDetalhe.createRoute(servico.idServico)) {
                                            popUpTo(Screen.Home.route)
                                        }
                                    }
                                } else {
                                    errorMessage = "Erro ao criar serviço. Tente novamente."
                                }
                            }
                        } catch (e: Exception) {
                            errorMessage = "Erro de ligação."
                        }
                        isLoading = false
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                enabled = !isLoading && titulo.isNotBlank() && preco.isNotBlank()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp), color = MaterialTheme.colorScheme.onPrimary)
                } else {
                    Text("Confirmar Contratação", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

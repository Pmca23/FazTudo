package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.AvaliacaoRequest
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvaliarServicoScreen(
    navController: NavController,
    servicoId: Int,
    vendedorCategoriaId: Int,
    sessionManager: SessionManager
) {
    var nota by remember { mutableStateOf(0) }
    var comentario by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    
    val scope = rememberCoroutineScope()
    
    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Obrigado! 🎉") },
            text = { Text("A sua avaliação foi enviada com sucesso!") },
            confirmButton = {
                Button(
                    onClick = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Home.route) { inclusive = true } } },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                ) { Text("Voltar ao Início") }
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Avaliar Serviço") },
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar") } }
        )
        
        Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(24.dp))
            
            Text("Como foi a sua experiência?", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(8.dp))
            Text("A sua opinião ajuda outros utilizadores.", style = MaterialTheme.typography.bodyMedium, color = TextGray, textAlign = TextAlign.Center)
            
            Spacer(modifier = Modifier.height(40.dp))
            
            Text("Toque para avaliar", style = MaterialTheme.typography.labelMedium, color = TextGray)
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                (1..5).forEach { star ->
                    IconButton(onClick = { nota = star }, modifier = Modifier.size(56.dp)) {
                        Icon(
                            imageVector = if (star <= nota) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = "$star estrelas",
                            tint = if (star <= nota) StarYellow else DividerGray,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = when (nota) { 1 -> "Muito Mau"; 2 -> "Mau"; 3 -> "Razoável"; 4 -> "Bom"; 5 -> "Excelente!"; else -> "" },
                style = MaterialTheme.typography.titleMedium,
                color = if (nota > 0) PrimaryBlue else TextGray
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text("Comentário (opcional)", style = MaterialTheme.typography.labelLarge, color = TextDark, modifier = Modifier.align(Alignment.Start))
            Spacer(modifier = Modifier.height(8.dp))
            
            OutlinedTextField(
                value = comentario,
                onValueChange = { comentario = it },
                placeholder = { Text("Conte-nos mais sobre a sua experiência...") },
                modifier = Modifier.fillMaxWidth().height(150.dp),
                shape = RoundedCornerShape(12.dp),
                maxLines = 6
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            errorMessage?.let { Text(text = it, color = ErrorRed, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(bottom = 16.dp)) }
            
            Button(
                onClick = {
                    scope.launch {
                        isLoading = true
                        errorMessage = null
                        try {
                            val token = sessionManager.getAuthHeader().firstOrNull()
                            if (token != null) {
                                val response = RetrofitClient.api.criarAvaliacao(
                                    token,
                                    AvaliacaoRequest(idVendedorCategoria = vendedorCategoriaId, nota = nota, comentario = comentario.ifBlank { null })
                                )
                                if (response.isSuccessful) showSuccessDialog = true
                                else errorMessage = "Erro ao enviar avaliação."
                            }
                        } catch (e: Exception) { errorMessage = "Erro de ligação." }
                        isLoading = false
                    }
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                enabled = !isLoading && nota > 0
            ) {
                if (isLoading) CircularProgressIndicator(modifier = Modifier.size(24.dp), color = MaterialTheme.colorScheme.onPrimary)
                else Text("Enviar Avaliação", fontWeight = FontWeight.SemiBold)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            TextButton(onClick = { navController.navigate(Screen.Home.route) { popUpTo(Screen.Home.route) { inclusive = true } } }) {
                Text("Avaliar mais tarde", color = TextGray)
            }
        }
    }
}

package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.ServicoResponse
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicoDetalheScreen(
    navController: NavController,
    servicoId: Int,
    sessionManager: SessionManager
) {
    var servico by remember { mutableStateOf<ServicoResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var isUpdating by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var dialogAction by remember { mutableStateOf("") }
    
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(servicoId) {
        try {
            val token = sessionManager.getAuthHeader().firstOrNull()
            if (token != null) {
                val response = RetrofitClient.api.getServicoById(token, servicoId)
                if (response.isSuccessful) servico = response.body()
            }
        } catch (e: Exception) { }
        isLoading = false
    }
    
    if (showConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text(when (dialogAction) { "concluir" -> "Concluir Serviço?"; "cancelar" -> "Cancelar Serviço?"; else -> "Confirmar" }) },
            text = { Text(when (dialogAction) { "concluir" -> "Após confirmar, poderá avaliar o prestador."; "cancelar" -> "Tem a certeza?"; else -> "" }) },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            isUpdating = true
                            try {
                                val token = sessionManager.getAuthHeader().firstOrNull()
                                if (token != null) {
                                    val response = when (dialogAction) {
                                        "concluir" -> RetrofitClient.api.concluirServico(token, servicoId)
                                        "cancelar" -> RetrofitClient.api.cancelarServico(token, servicoId)
                                        else -> null
                                    }
                                    if (response?.isSuccessful == true) {
                                        servico = response.body()
                                        if (dialogAction == "concluir" && servico != null) {
                                            navController.navigate(Screen.AvaliarServico.createRoute(servicoId, servico!!.vendedor.idVendedor))
                                        }
                                    }
                                }
                            } catch (e: Exception) { }
                            isUpdating = false
                            showConfirmDialog = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = if (dialogAction == "cancelar") ErrorRed else PrimaryBlue)
                ) { Text("Confirmar") }
            },
            dismissButton = { TextButton(onClick = { showConfirmDialog = false }) { Text("Cancelar") } }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Detalhes do Serviço") },
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar") } }
        )
        
        when {
            isLoading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
            servico == null -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Serviço não encontrado", color = ErrorRed) }
            else -> {
                val s = servico!!
                val estadoColor = when (s.estado.nome) { "Pendente" -> WarningYellow; "Em Andamento" -> PrimaryBlue; "Concluído" -> SuccessGreen; "Cancelado" -> ErrorRed; else -> TextGray }
                
                Column(modifier = Modifier.padding(16.dp)) {
                    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                Text(s.titulo, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                                AssistChip(onClick = { }, label = { Text(s.estado.nome) }, colors = AssistChipDefaults.assistChipColors(containerColor = estadoColor.copy(alpha = 0.15f)))
                            }
                            
                            s.descricao?.let { Spacer(modifier = Modifier.height(16.dp)); Text(it, style = MaterialTheme.typography.bodyMedium, color = TextGray) }
                            
                            Spacer(modifier = Modifier.height(16.dp)); HorizontalDivider(); Spacer(modifier = Modifier.height(16.dp))
                            
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Outlined.Person, contentDescription = null, tint = PrimaryBlue)
                                Spacer(modifier = Modifier.width(12.dp))
                                Column { Text("Prestador", style = MaterialTheme.typography.labelMedium, color = TextGray); Text(s.vendedor.nome, fontWeight = FontWeight.Medium) }
                            }
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Outlined.Category, contentDescription = null, tint = PrimaryBlue)
                                Spacer(modifier = Modifier.width(12.dp))
                                Column { Text("Categoria", style = MaterialTheme.typography.labelMedium, color = TextGray); Text(s.categoria.nome) }
                            }
                            
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Outlined.Euro, contentDescription = null, tint = PrimaryBlue)
                                Spacer(modifier = Modifier.width(12.dp))
                                Column { Text("Valor", style = MaterialTheme.typography.labelMedium, color = TextGray); Text("€${String.format("%.2f", s.preco)}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = PrimaryBlue) }
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    when (s.estado.nome) {
                        "Pendente" -> {
                            OutlinedButton(onClick = { dialogAction = "cancelar"; showConfirmDialog = true }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.outlinedButtonColors(contentColor = ErrorRed)) {
                                Icon(Icons.Outlined.Cancel, contentDescription = null); Spacer(modifier = Modifier.width(8.dp)); Text("Cancelar Serviço")
                            }
                        }
                        "Em Andamento" -> {
                            Button(onClick = { dialogAction = "concluir"; showConfirmDialog = true }, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen), enabled = !isUpdating) {
                                if (isUpdating) CircularProgressIndicator(modifier = Modifier.size(24.dp), color = MaterialTheme.colorScheme.onPrimary)
                                else { Icon(Icons.Default.CheckCircle, contentDescription = null); Spacer(modifier = Modifier.width(8.dp)); Text("Marcar como Concluído", fontWeight = FontWeight.SemiBold) }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            OutlinedButton(onClick = { dialogAction = "cancelar"; showConfirmDialog = true }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.outlinedButtonColors(contentColor = ErrorRed)) { Text("Cancelar Serviço") }
                        }
                        "Concluído" -> {
                            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = SuccessGreen.copy(alpha = 0.1f))) {
                                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = SuccessGreen)
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text("Serviço concluído!", color = SuccessGreen, fontWeight = FontWeight.Medium)
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = { navController.navigate(Screen.AvaliarServico.createRoute(servicoId, s.vendedor.idVendedor)) }, modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)) {
                                Icon(Icons.Default.Star, contentDescription = null); Spacer(modifier = Modifier.width(8.dp)); Text("Avaliar Prestador", fontWeight = FontWeight.SemiBold)
                            }
                        }
                        "Cancelado" -> {
                            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = ErrorRed.copy(alpha = 0.1f))) {
                                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.Cancel, contentDescription = null, tint = ErrorRed)
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text("Serviço cancelado", color = ErrorRed)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

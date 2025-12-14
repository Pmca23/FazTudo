package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Person
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
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeusServicosVendedorScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var servicos by remember { mutableStateOf<List<ServicoResponse>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isUpdating by remember { mutableStateOf<Int?>(null) }
    
    val scope = rememberCoroutineScope()
    
    fun loadServicos() {
        scope.launch {
            try {
                val token = sessionManager.getAuthHeader().firstOrNull()
                if (token != null) {
                    val response = RetrofitClient.api.getMeusServicosComoVendedor(token)
                    if (response.isSuccessful) servicos = response.body() ?: emptyList()
                }
            } catch (e: Exception) { }
            isLoading = false
        }
    }
    
    LaunchedEffect(Unit) { loadServicos() }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Serviços Recebidos") },
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar") } }
        )
        
        when {
            isLoading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
            servicos.isEmpty() -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Ainda não tem serviços", style = MaterialTheme.typography.titleMedium)
                        Text("Os pedidos de clientes aparecerão aqui", color = TextGray)
                    }
                }
            }
            else -> {
                LazyColumn(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(servicos) { servico ->
                        ServicoVendedorCard(
                            servico = servico,
                            isUpdating = isUpdating == servico.idServico,
                            onIniciar = {
                                scope.launch {
                                    isUpdating = servico.idServico
                                    try {
                                        val token = sessionManager.getAuthHeader().firstOrNull()
                                        if (token != null) {
                                            val response = RetrofitClient.api.iniciarServico(token, servico.idServico)
                                            if (response.isSuccessful) loadServicos()
                                        }
                                    } catch (e: Exception) { }
                                    isUpdating = null
                                }
                            },
                            onConcluir = {
                                scope.launch {
                                    isUpdating = servico.idServico
                                    try {
                                        val token = sessionManager.getAuthHeader().firstOrNull()
                                        if (token != null) {
                                            val response = RetrofitClient.api.concluirServico(token, servico.idServico)
                                            if (response.isSuccessful) loadServicos()
                                        }
                                    } catch (e: Exception) { }
                                    isUpdating = null
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ServicoVendedorCard(
    servico: ServicoResponse,
    isUpdating: Boolean,
    onIniciar: () -> Unit,
    onConcluir: () -> Unit
) {
    val estadoColor = when (servico.estado.nome) {
        "Pendente" -> WarningYellow
        "Em Andamento" -> PrimaryBlue
        "Concluído" -> SuccessGreen
        "Cancelado" -> ErrorRed
        else -> TextGray
    }
    
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(servico.titulo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                AssistChip(onClick = { }, label = { Text(servico.estado.nome, style = MaterialTheme.typography.labelSmall) }, colors = AssistChipDefaults.assistChipColors(containerColor = estadoColor.copy(alpha = 0.1f)))
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Person, contentDescription = null, modifier = Modifier.size(16.dp), tint = TextGray)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Cliente: ${servico.cliente.nome}", style = MaterialTheme.typography.bodySmall, color = TextGray)
            }
            
            servico.descricao?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it, style = MaterialTheme.typography.bodySmall, color = TextGray, maxLines = 2)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("€${String.format("%.2f", servico.preco)}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = PrimaryBlue)
                
                when (servico.estado.nome) {
                    "Pendente" -> {
                        Button(
                            onClick = onIniciar,
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            enabled = !isUpdating,
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            if (isUpdating) CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = MaterialTheme.colorScheme.onPrimary)
                            else { Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp)); Spacer(modifier = Modifier.width(4.dp)); Text("Aceitar") }
                        }
                    }
                    "Em Andamento" -> {
                        Button(
                            onClick = onConcluir,
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            enabled = !isUpdating,
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            if (isUpdating) CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = MaterialTheme.colorScheme.onPrimary)
                            else Text("Concluir")
                        }
                    }
                }
            }
        }
    }
}

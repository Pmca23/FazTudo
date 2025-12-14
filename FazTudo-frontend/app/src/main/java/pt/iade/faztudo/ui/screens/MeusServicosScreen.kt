package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun MeusServicosScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var servicos by remember { mutableStateOf<List<ServicoResponse>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(Unit) {
        val token = sessionManager.getAuthHeader().firstOrNull()
        token?.let {
            try {
                val response = RetrofitClient.api.getMeusServicos(it)
                if (response.isSuccessful) servicos = response.body() ?: emptyList()
            } catch (e: Exception) { }
        }
        isLoading = false
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Meus Serviços") },
            navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar") } }
        )
        
        when {
            isLoading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
            servicos.isEmpty() -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Ainda não tem serviços", style = MaterialTheme.typography.titleMedium)
                        Text("Contrate um prestador para começar", color = TextGray)
                    }
                }
            }
            else -> {
                LazyColumn(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(servicos) { servico ->
                        ServicoCard(
                            servico = servico,
                            onClick = { navController.navigate(Screen.ServicoDetalhe.createRoute(servico.idServico)) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ServicoCard(servico: ServicoResponse, onClick: () -> Unit) {
    val estadoColor = when (servico.estado.nome) {
        "Pendente" -> WarningYellow
        "Em Andamento" -> PrimaryBlue
        "Concluído" -> SuccessGreen
        "Cancelado" -> ErrorRed
        else -> TextGray
    }
    
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(servico.titulo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                AssistChip(
                    onClick = { },
                    label = { Text(servico.estado.nome, style = MaterialTheme.typography.labelSmall) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = estadoColor.copy(alpha = 0.1f))
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            Text("Prestador: ${servico.vendedor.nome}", style = MaterialTheme.typography.bodyMedium, color = TextGray)
            Text("Categoria: ${servico.categoria.nome}", style = MaterialTheme.typography.bodySmall, color = TextGray)
            
            Spacer(modifier = Modifier.height(8.dp))
            Text("€${String.format("%.2f", servico.preco)}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = PrimaryBlue)
        }
    }
}

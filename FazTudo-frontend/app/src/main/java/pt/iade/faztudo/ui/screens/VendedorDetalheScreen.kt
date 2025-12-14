package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
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
import pt.iade.faztudo.data.model.AvaliacaoResponse
import pt.iade.faztudo.data.model.VendedorResponse
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendedorDetalheScreen(
    navController: NavController,
    vendedorId: Int,
    sessionManager: SessionManager
) {
    var vendedor by remember { mutableStateOf<VendedorResponse?>(null) }
    var avaliacoes by remember { mutableStateOf<List<AvaliacaoResponse>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isLoggedIn by remember { mutableStateOf(false) }
    var showLoginDialog by remember { mutableStateOf(false) }
    
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(Unit) {
        sessionManager.isLoggedIn.collect { loggedIn ->
            isLoggedIn = loggedIn
        }
    }
    
    LaunchedEffect(vendedorId) {
        scope.launch {
            try {
                val vendedorResponse = RetrofitClient.api.getVendedorById(vendedorId)
                if (vendedorResponse.isSuccessful) {
                    vendedor = vendedorResponse.body()
                }
                
                val avaliacoesResponse = RetrofitClient.api.getAvaliacoesByVendedor(vendedorId)
                if (avaliacoesResponse.isSuccessful) {
                    avaliacoes = avaliacoesResponse.body() ?: emptyList()
                }
            } catch (e: Exception) {
                // Handle error
            }
            isLoading = false
        }
    }
    
    // Dialog login necessário
    if (showLoginDialog) {
        AlertDialog(
            onDismissRequest = { showLoginDialog = false },
            title = { Text("Login Necessário") },
            text = { Text("Precisa de fazer login para contratar um serviço.") },
            confirmButton = {
                Button(
                    onClick = {
                        showLoginDialog = false
                        navController.navigate(Screen.Login.route)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                ) {
                    Text("Fazer Login")
                }
            },
            dismissButton = {
                TextButton(onClick = { showLoginDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(vendedor?.nome ?: "Prestador") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                }
            }
        )
        
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            vendedor?.let { v ->
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = v.nome,
                                        style = MaterialTheme.typography.headlineSmall,
                                        fontWeight = FontWeight.Bold
                                    )
                                    
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Default.Star, contentDescription = null, tint = StarYellow)
                                        Text(
                                            text = String.format("%.1f", v.mediaAvaliacoes ?: 0.0),
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                
                                Spacer(modifier = Modifier.height(16.dp))
                                
                                v.telemovel?.let { tel ->
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Outlined.Phone, contentDescription = null, tint = PrimaryBlue)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(tel)
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                                
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.Email, contentDescription = null, tint = PrimaryBlue)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(v.email)
                                }
                                
                                v.localizacao?.cidade?.let { cidade ->
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = PrimaryBlue)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(cidade)
                                    }
                                }
                            }
                        }
                    }
                    
                    item {
                        Text("Serviços Disponíveis", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    }
                    
                    v.categorias?.let { cats ->
                        items(cats) { cat ->
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
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            cat.categoria.nome, 
                                            style = MaterialTheme.typography.titleSmall, 
                                            fontWeight = FontWeight.Medium
                                        )
                                        cat.descricao?.let {
                                            Text(it, style = MaterialTheme.typography.bodySmall, color = TextGray)
                                        }
                                        cat.mediaAvaliacoes?.let { media ->
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(
                                                    Icons.Default.Star,
                                                    contentDescription = null,
                                                    tint = StarYellow,
                                                    modifier = Modifier.size(14.dp)
                                                )
                                                Text(
                                                    " ${String.format("%.1f", media)} (${cat.totalAvaliacoes ?: 0})",
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = TextGray
                                                )
                                            }
                                        }
                                    }
                                    
                                    Button(
                                        onClick = {
                                            if (isLoggedIn) {
                                                navController.navigate(
                                                    Screen.ContratarServico.createRoute(cat.idVendedorCategoria)

                                                )

                                            } else {
                                                showLoginDialog = true
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                                    ) {
                                        Text("Contratar")
                                    }
                                }
                            }
                        }
                    }
                    
                    if (avaliacoes.isNotEmpty()) {
                        item {
                            Text(
                                "Avaliações (${avaliacoes.size})", 
                                style = MaterialTheme.typography.titleMedium, 
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        
                        items(avaliacoes) { avaliacao ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(), 
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            avaliacao.user.nome, 
                                            style = MaterialTheme.typography.titleSmall, 
                                            fontWeight = FontWeight.Medium
                                        )
                                        Row {
                                            repeat(avaliacao.nota) {
                                                Icon(
                                                    Icons.Default.Star, 
                                                    contentDescription = null, 
                                                    tint = StarYellow, 
                                                    modifier = Modifier.size(16.dp)
                                                )
                                            }
                                        }
                                    }
                                    avaliacao.comentario?.let {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(it, style = MaterialTheme.typography.bodyMedium, color = TextGray)
                                    }
                                }
                            }
                        }
                    }
                    
                    item { Spacer(modifier = Modifier.height(16.dp)) }
                }
            }
        }
    }
}

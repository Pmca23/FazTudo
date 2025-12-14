package pt.iade.faztudo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import pt.iade.faztudo.data.api.RetrofitClient
import pt.iade.faztudo.data.model.UserResponse
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.navigation.Screen
import pt.iade.faztudo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(
    navController: NavController,
    sessionManager: SessionManager
) {
    var user by remember { mutableStateOf<UserResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val token = sessionManager.getAuthHeader().firstOrNull()
        token?.let {
            try {
                val response = RetrofitClient.api.getCurrentUser(it)
                if (response.isSuccessful) user = response.body()
            } catch (e: Exception) {
                // Em caso de erro, poderia fazer logout ou mostrar uma mensagem
            }
        }
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meu Perfil") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (user == null) {
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
                Text("Não foi possível carregar o perfil.")
            }
        } else {
            user?.let { u ->
                // Usar LazyColumn para listas
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 16.dp)
                ) {
                    //  perfil
                    item {
                        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Text(u.nome, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(16.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Outlined.Email, contentDescription = null, tint = PrimaryBlue)
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(u.email)
                                }
                                u.telemovel?.let { tel ->
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Outlined.Phone, contentDescription = null, tint = PrimaryBlue)
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(tel)
                                    }
                                }
                                u.localizacao?.cidade?.let { cidade ->
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(Icons.Outlined.LocationOn, contentDescription = null, tint = PrimaryBlue)
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(cidade)
                                    }
                                }
                                if (u.isVendedor) {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    AssistChip(
                                        onClick = { },
                                        label = { Text("Prestador de Serviços") },
                                        leadingIcon = { Icon(Icons.Outlined.Build, contentDescription = null, modifier = Modifier.size(18.dp)) },
                                        colors = AssistChipDefaults.assistChipColors(containerColor = SuccessGreen.copy(alpha = 0.1f))
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    // Menu - Cliente
                    item {
                        Text("Como Cliente", style = MaterialTheme.typography.titleSmall, color = TextGray, modifier = Modifier.padding(bottom = 8.dp))
                        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
                            Column {
                                MenuListItem(
                                    icon = Icons.Outlined.Assignment,
                                    text = "Meus Serviços",
                                    onClick = { navController.navigate(Screen.MeusServicos.route) }
                                )
                                HorizontalDivider()
                                MenuListItem(
                                    icon = Icons.Outlined.Star,
                                    text = "Minhas Avaliações",
                                    onClick = { /* TODO */ }
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    // Menu - Vendedor (só aparece se for vendedor) // nao funciona
                    if (u.isVendedor) {
                        item {
                            Text("Como Prestador", style = MaterialTheme.typography.titleSmall, color = TextGray, modifier = Modifier.padding(bottom = 8.dp))
                            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
                                Column {
                                    MenuListItem(
                                        icon = Icons.Outlined.WorkOutline,
                                        text = "Serviços Recebidos",
                                        onClick = { navController.navigate(Screen.MeusServicosVendedor.route) }
                                    )
                                    HorizontalDivider()
                                    MenuListItem(
                                        icon = Icons.Outlined.StarBorder,
                                        text = "Minhas Avaliações Recebidas",
                                        onClick = { /* TODO */ }
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }

                    // Configurações
                    item {
                        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp)) {
                            MenuListItem(
                                icon = Icons.Outlined.Edit,
                                text = "Editar Perfil",
                                onClick = { /* TODO */ }
                            )
                        }
                    }

                    // Logout
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedButton(
                            onClick = {
                                scope.launch {
                                    sessionManager.clearSession()
                                    navController.navigate(Screen.Home.route) { popUpTo(0) { inclusive = true } }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = ErrorRed)
                        ) {
                            Icon(Icons.Outlined.ExitToApp, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Terminar Sessão")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MenuListItem(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = PrimaryBlue)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Outlined.ChevronRight, contentDescription = null, tint = TextGray)
    }
}

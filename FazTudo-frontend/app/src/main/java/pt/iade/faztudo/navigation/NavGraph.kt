package pt.iade.faztudo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pt.iade.faztudo.data.repository.SessionManager
import pt.iade.faztudo.ui.screens.*

@Composable
fun NavGraph(
    navController: NavHostController,
    sessionManager: SessionManager
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        // Home
        composable(Screen.Home.route) {
            HomeScreen(navController = navController, sessionManager = sessionManager)
        }
        
        // Auth
        composable(Screen.Login.route) {
            LoginScreen(navController = navController, sessionManager = sessionManager)
        }
        
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController, sessionManager = sessionManager)
        }
        
        // Vendedores por categoria (lista)
        composable(
            route = Screen.VendedoresByCategoria.route,
            arguments = listOf(navArgument("categoriaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoriaId = backStackEntry.arguments?.getInt("categoriaId") ?: 0
            VendedoresScreen(navController = navController, categoriaId = categoriaId)
        }
        
        // Mapa de vendedores
        composable(
            route = Screen.MapaVendedores.route,
            arguments = listOf(navArgument("categoriaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoriaId = backStackEntry.arguments?.getInt("categoriaId") ?: 0
            MapaVendedoresScreen(navController = navController, categoriaId = categoriaId, sessionManager = sessionManager)
        }
        
        // Detalhes do vendedor
        composable(
            route = Screen.VendedorDetalhe.route,
            arguments = listOf(navArgument("vendedorId") { type = NavType.IntType })
        ) { backStackEntry ->
            val vendedorId = backStackEntry.arguments?.getInt("vendedorId") ?: 0
            VendedorDetalheScreen(navController = navController, vendedorId = vendedorId, sessionManager = sessionManager)
        }
        
        // Contratar serviço
        composable(
            route = Screen.ContratarServico.route,
            arguments = listOf(navArgument("vendedorCategoriaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val vendedorCategoriaId = backStackEntry.arguments?.getInt("vendedorCategoriaId") ?: 0
            ContratarServicoScreen(navController = navController, vendedorCategoriaId = vendedorCategoriaId, sessionManager = sessionManager)
        }
        
        // Perfil
        composable(Screen.Perfil.route) {
            PerfilScreen(navController = navController, sessionManager = sessionManager)
        }
        
        // Meus serviços (cliente)
        composable(Screen.MeusServicos.route) {
            MeusServicosScreen(navController = navController, sessionManager = sessionManager)
        }
        
        // Meus serviços (vendedor) // n#ao funciona
        composable(Screen.MeusServicosVendedor.route) {
            MeusServicosVendedorScreen(navController = navController, sessionManager = sessionManager)
        }
        
        // Detalhes do serviço
        composable(
            route = Screen.ServicoDetalhe.route,
            arguments = listOf(navArgument("servicoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val servicoId = backStackEntry.arguments?.getInt("servicoId") ?: 0
            ServicoDetalheScreen(navController = navController, servicoId = servicoId, sessionManager = sessionManager)
        }
        
        // Avaliar serviço //nao impletemntado
        composable(
            route = Screen.AvaliarServico.route,
            arguments = listOf(
                navArgument("servicoId") { type = NavType.IntType },
                navArgument("vendedorCategoriaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val servicoId = backStackEntry.arguments?.getInt("servicoId") ?: 0
            val vendedorCategoriaId = backStackEntry.arguments?.getInt("vendedorCategoriaId") ?: 0
            AvaliarServicoScreen(navController = navController, servicoId = servicoId, vendedorCategoriaId = vendedorCategoriaId, sessionManager = sessionManager)
        }
    }
}

package pt.iade.faztudo.navigation

sealed class Screen(val route: String) {
    // Ecrãs principais
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object Perfil : Screen("perfil")
    
    // Categorias e Vendedores
    object Categorias : Screen("categorias")
    
    object VendedoresByCategoria : Screen("vendedores/{categoriaId}") {
        fun createRoute(categoriaId: Int) = "vendedores/$categoriaId"
    }
    
    // Mapa de vendedores por categoria
    object MapaVendedores : Screen("mapa-vendedores/{categoriaId}") {
        fun createRoute(categoriaId: Int) = "mapa-vendedores/$categoriaId"
    }
    
    object VendedorDetalhe : Screen("vendedor/{vendedorId}") {
        fun createRoute(vendedorId: Int) = "vendedor/$vendedorId"
    }
    
    //  Contratar serviço
    object ContratarServico : Screen("contratar/{vendedorCategoriaId}") {
        fun createRoute(vendedorCategoriaId: Int) = "contratar/$vendedorCategoriaId"
    }
    
    // Serviços
    object MeusServicos : Screen("meus-servicos")
    
    //  serviço (para marcar como concluído)
    object ServicoDetalhe : Screen("servico/{servicoId}") {
        fun createRoute(servicoId: Int) = "servico/$servicoId"
    }
    
    //  Avaliar serviço // nao foi feito
    object AvaliarServico : Screen("avaliar/{servicoId}/{vendedorCategoriaId}") {
        fun createRoute(servicoId: Int, vendedorCategoriaId: Int) = "avaliar/$servicoId/$vendedorCategoriaId"
    }
    
    // Avaliações
    object MinhasAvaliacoes : Screen("minhas-avaliacoes")
    
    // Para vendedor criar serviço/oferta
    object CriarOferta : Screen("criar-oferta")
    
    // Serviços do vendedor
    object MeusServicosVendedor : Screen("meus-servicos-vendedor")
}

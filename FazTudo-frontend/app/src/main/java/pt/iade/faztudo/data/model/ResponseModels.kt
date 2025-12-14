package pt.iade.faztudo.data.model

// RESPONSE DTOs

data class AuthResponse(
    val token: String,
    val tipo: String,
    val idUser: Int,
    val nome: String,
    val email: String,
    val isVendedor: Boolean,
    val idVendedor: Int?,
    val roles: List<String>
)

data class LocalizacaoResponse(
    val idLocalizacao: Int?,
    val cidade: String?,
    val morada: String?,
    val codigoPostal: String?,
    val latitude: Double?,
    val longitude: Double?
)

data class CategoriaResponse(
    val idCategoria: Int,
    val nome: String
)

data class EstadoResponse(
    val idEstado: Int,
    val nome: String
)

data class UserResumoResponse(
    val idUser: Int,
    val nome: String
)

data class VendedorResumoResponse(
    val idVendedor: Int,
    val nome: String,
    val telemovel: String?,
    val mediaAvaliacoes: Double?
)

data class VendedorCategoriaResponse(
    val idVendedorCategoria: Int,
    val categoria: CategoriaResponse,
    val descricao: String?,
    val dataRegisto: String?,
    val mediaAvaliacoes: Double?,
    val totalAvaliacoes: Int?
)

data class VendedorResponse(
    val idVendedor: Int,
    val nome: String,
    val email: String,
    val telemovel: String?,
    val dataRegisto: String?,
    val localizacao: LocalizacaoResponse?,
    val categorias: List<VendedorCategoriaResponse>?,
    val mediaAvaliacoes: Double?,
    val totalAvaliacoes: Int?,
    val distanciaKm: Double?
)

data class UserResponse(
    val idUser: Int,
    val nome: String,
    val email: String,
    val telemovel: String?,
    val dataRegisto: String?,
    val localizacao: LocalizacaoResponse?,
    val isVendedor: Boolean,
    val vendedor: VendedorResponse?
)

data class ServicoResponse(
    val idServico: Int,
    val titulo: String,
    val descricao: String?,
    val preco: Double,
    val dataPublicacao: String?,
    val dataConclusao: String?,
    val estado: EstadoResponse,
    val vendedor: VendedorResumoResponse,
    val categoria: CategoriaResponse,
    val cliente: UserResumoResponse
)

data class AvaliacaoResponse(
    val idAvaliacao: Int,
    val nota: Int,
    val comentario: String?,
    val dataAvaliacao: String?,
    val user: UserResumoResponse,
    val vendedor: VendedorResumoResponse,
    val categoria: CategoriaResponse
)

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val timestamp: String?,
    val data: Any?
)

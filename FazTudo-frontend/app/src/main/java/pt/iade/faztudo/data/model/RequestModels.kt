package pt.iade.faztudo.data.model

// REQUEST DTOs

data class LoginRequest(
    val email: String,
    val palavraPasse: String
)

data class RegisterRequest(
    val nome: String,
    val email: String,
    val palavraPasse: String,
    val telemovel: String? = null,
    val cidade: String? = null,
    val morada: String? = null,
    val codigoPostal: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val registarComoVendedor: Boolean = false,
    val categorias: List<Int>? = null
)

data class UpdateUserRequest(
    val nome: String? = null,
    val telemovel: String? = null,
    val cidade: String? = null,
    val morada: String? = null,
    val codigoPostal: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
)

data class ServicoRequest(
    val titulo: String,
    val descricao: String? = null,
    val preco: Double,
    val idVendedorCategoria: Int
)

data class AvaliacaoRequest(
    val idVendedorCategoria: Int,
    val nota: Int,
    val comentario: String? = null
)

package pt.iade.faztudo.data.api

import pt.iade.faztudo.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface FazTudoApi {


    // AUTH

    
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    // CATEGORIAS
    
    @GET("api/categorias")
    suspend fun getCategorias(): Response<List<CategoriaResponse>>

    @GET("api/categorias/{id}")
    suspend fun getCategoriaById(@Path("id") id: Int): Response<CategoriaResponse>

    @GET("api/categorias/search")
    suspend fun searchCategorias(@Query("termo") termo: String): Response<List<CategoriaResponse>>

    // ESTADOS
    
    @GET("api/estados")
    suspend fun getEstados(): Response<List<EstadoResponse>>

    // VENDEDORES
    
    @GET("api/vendedores")
    suspend fun getVendedores(): Response<List<VendedorResponse>>

    @GET("api/vendedores/{id}")
    suspend fun getVendedorById(@Path("id") id: Int): Response<VendedorResponse>

    @GET("api/vendedores/categoria/{idCategoria}")
    suspend fun getVendedoresByCategoria(
        @Path("idCategoria") idCategoria: Int
    ): Response<List<VendedorResponse>>

    @GET("api/vendedores/categoria/{idCategoria}/proximos")
    suspend fun getVendedoresProximos(
        @Path("idCategoria") idCategoria: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("raioKm") raioKm: Double = 50.0
    ): Response<List<VendedorResponse>>

    @GET("api/vendedores/{id}/avaliacoes")
    suspend fun getAvaliacoesByVendedor(@Path("id") id: Int): Response<List<AvaliacaoResponse>>

    // USERS

    @GET("api/users/me")
    suspend fun getCurrentUser(@Header("Authorization") token: String): Response<UserResponse>

    @PUT("api/users/me")
    suspend fun updateCurrentUser(
        @Header("Authorization") token: String,
        @Body request: UpdateUserRequest
    ): Response<UserResponse>

    // SERVICOS

    @POST("api/servicos")
    suspend fun criarServico(
        @Header("Authorization") token: String,
        @Body request: ServicoRequest
    ): Response<ServicoResponse>

    @GET("api/servicos/{id}")
    suspend fun getServicoById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<ServicoResponse>

    @GET("api/servicos/meus")
    suspend fun getMeusServicos(
        @Header("Authorization") token: String
    ): Response<List<ServicoResponse>>

    @GET("api/servicos/meus/vendedor")
    suspend fun getMeusServicosComoVendedor(
        @Header("Authorization") token: String
    ): Response<List<ServicoResponse>>

    @PATCH("api/servicos/{id}/iniciar")
    suspend fun iniciarServico(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<ServicoResponse>

    @PATCH("api/servicos/{id}/concluir")
    suspend fun concluirServico(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<ServicoResponse>

    @PATCH("api/servicos/{id}/cancelar")
    suspend fun cancelarServico(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<ServicoResponse>

    // AVALIACOES (Protegidos)
    
    @POST("api/avaliacoes")
    suspend fun criarAvaliacao(
        @Header("Authorization") token: String,
        @Body request: AvaliacaoRequest
    ): Response<AvaliacaoResponse>

    @GET("api/avaliacoes/minhas")
    suspend fun getMinhasAvaliacoes(
        @Header("Authorization") token: String
    ): Response<List<AvaliacaoResponse>>

    @PUT("api/avaliacoes/{id}")
    suspend fun atualizarAvaliacao(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body request: AvaliacaoRequest
    ): Response<AvaliacaoResponse>

    @DELETE("api/avaliacoes/{id}")
    suspend fun removerAvaliacao(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<ApiResponse>
}

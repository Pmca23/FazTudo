package pt.iade.faztudo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A palavra-passe é obrigatória")
    @Size(min = 6, max = 100, message = "A palavra-passe deve ter entre 6 e 100 caracteres")
    private String palavraPasse;

    @Size(max = 20, message = "O telemóvel deve ter no máximo 20 caracteres")
    private String telemovel;

    private String cidade;
    private String morada;
    private String codigoPostal;
    private Double latitude;
    private Double longitude;

    private boolean registarComoVendedor;
    private List<Integer> categorias;
}
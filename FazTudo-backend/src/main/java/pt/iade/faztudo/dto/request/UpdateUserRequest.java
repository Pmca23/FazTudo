package pt.iade.faztudo.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserRequest {

    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @Size(max = 20, message = "O telemóvel deve ter no máximo 20 caracteres")
    private String telemovel;

    private String cidade;
    private String morada;
    private String codigoPostal;
    private Double latitude;
    private Double longitude;
}
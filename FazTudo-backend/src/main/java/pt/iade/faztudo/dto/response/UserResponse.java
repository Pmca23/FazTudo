package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer idUser;
    private String nome;
    private String email;
    private String telemovel;
    private LocalDateTime dataRegisto;
    private LocalizacaoResponse localizacao;
    private boolean isVendedor;
    private VendedorResponse vendedor;
}
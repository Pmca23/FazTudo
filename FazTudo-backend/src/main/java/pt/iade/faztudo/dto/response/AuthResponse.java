package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

    private String token;
    private String tipo;
    private Integer idUser;
    private String nome;
    private String email;
    private boolean isVendedor;
    private Integer idVendedor;
    private List<String> roles;
}
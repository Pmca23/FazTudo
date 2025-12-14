package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendedorResumoResponse {

    private Integer idVendedor;
    private String nome;
    private String telemovel;
    private Double mediaAvaliacoes;
}
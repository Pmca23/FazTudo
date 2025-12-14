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
public class VendedorCategoriaResponse {

    private Integer idVendedorCategoria;
    private CategoriaResponse categoria;
    private String descricao;
    private LocalDateTime dataRegisto;
    private Double mediaAvaliacoes;
    private Integer totalAvaliacoes;
}
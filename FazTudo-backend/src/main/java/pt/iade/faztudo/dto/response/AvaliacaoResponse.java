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
public class AvaliacaoResponse {

    private Integer idAvaliacao;
    private Integer nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;
    private UserResumoResponse user;
    private VendedorResumoResponse vendedor;
    private CategoriaResponse categoria;
}
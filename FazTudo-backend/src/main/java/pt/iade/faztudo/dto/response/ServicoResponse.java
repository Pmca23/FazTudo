package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoResponse {

    private Integer idServico;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime dataPublicacao;
    private LocalDateTime dataConclusao;
    private EstadoResponse estado;
    private VendedorResumoResponse vendedor;
    private CategoriaResponse categoria;
    private UserResumoResponse cliente;
}
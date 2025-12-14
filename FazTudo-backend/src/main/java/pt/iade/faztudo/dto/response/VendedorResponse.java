package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendedorResponse {

    private Integer idVendedor;
    private String nome;
    private String email;
    private String telemovel;
    private LocalDateTime dataRegisto;
    private LocalizacaoResponse localizacao;
    private List<VendedorCategoriaResponse> categorias;
    private Double mediaAvaliacoes;
    private Integer totalAvaliacoes;
    private Double distanciaKm;
}
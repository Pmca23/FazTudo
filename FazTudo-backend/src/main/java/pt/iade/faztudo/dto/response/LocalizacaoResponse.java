package pt.iade.faztudo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalizacaoResponse {

    private Integer idLocalizacao;
    private String cidade;
    private String morada;
    private String codigoPostal;
    private Double latitude;
    private Double longitude;
}
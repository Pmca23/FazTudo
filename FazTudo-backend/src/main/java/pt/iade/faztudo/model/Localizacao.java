package pt.iade.faztudo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "localizacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Integer idLocalizacao;

    @Column(name = "cidade", length = 80)
    private String cidade;

    @Column(name = "morada", length = 150)
    private String morada;

    @Column(name = "codigo_postal", length = 15)
    private String codigoPostal;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
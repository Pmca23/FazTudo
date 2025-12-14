package pt.iade.faztudo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendedor_categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendedorCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor_categoria")
    private Integer idVendedorCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "data_registo", nullable = false)
    private LocalDateTime dataRegisto;

    @OneToMany(mappedBy = "vendedorCategoria", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Servico> servicos = new ArrayList<>();

    @OneToMany(mappedBy = "vendedorCategoria", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        dataRegisto = LocalDateTime.now();
    }

    public Double getMediaAvaliacoes() {
        if (avaliacoes == null || avaliacoes.isEmpty()) {
            return 0.0;
        }
        return avaliacoes.stream()
                .filter(a -> a.getNota() != null)
                .mapToInt(Avaliacao::getNota)
                .average()
                .orElse(0.0);
    }
}
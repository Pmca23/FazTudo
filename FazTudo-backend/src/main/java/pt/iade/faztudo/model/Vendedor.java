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
@Table(name = "vendedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Integer idVendedor;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telemovel", length = 20)
    private String telemovel;

    @Column(name = "data_registo", nullable = false)
    private LocalDateTime dataRegisto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localizacao")
    private Localizacao localizacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", unique = true)
    private User user;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<VendedorCategoria> categorias = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        dataRegisto = LocalDateTime.now();
    }
}
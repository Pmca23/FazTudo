package pt.iade.faztudo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "palavra_passe", nullable = false, length = 255)
    private String palavraPasse;

    @Column(name = "telemovel", length = 20)
    private String telemovel;

    @Column(name = "data_registo", nullable = false)
    private LocalDateTime dataRegisto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localizacao")
    private Localizacao localizacao;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Vendedor vendedor;

    @PrePersist
    protected void onCreate() {
        dataRegisto = LocalDateTime.now();
    }

    // Implementação de UserDetails (Spring Security)

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (vendedor != null) {
            return List.of(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_VENDEDOR")
            );
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return palavraPasse;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
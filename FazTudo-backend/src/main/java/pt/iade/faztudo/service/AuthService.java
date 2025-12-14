package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.request.LoginRequest;
import pt.iade.faztudo.dto.request.RegisterRequest;
import pt.iade.faztudo.dto.response.AuthResponse;
import pt.iade.faztudo.exception.ConflictException;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.model.*;
import pt.iade.faztudo.repository.*;
import pt.iade.faztudo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final VendedorRepository vendedorRepository;
    private final VendedorCategoriaRepository vendedorCategoriaRepository;
    private final CategoriaRepository categoriaRepository;
    private final LocalizacaoRepository localizacaoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ConflictException("O email já está registado");
        }

        Localizacao localizacao = null;
        if (request.getCidade() != null || request.getMorada() != null || 
            request.getLatitude() != null) {
            localizacao = Localizacao.builder()
                    .cidade(request.getCidade())
                    .morada(request.getMorada())
                    .codigoPostal(request.getCodigoPostal())
                    .latitude(request.getLatitude())
                    .longitude(request.getLongitude())
                    .build();
            localizacao = localizacaoRepository.save(localizacao);
        }

        User user = User.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .palavraPasse(passwordEncoder.encode(request.getPalavraPasse()))
                .telemovel(request.getTelemovel())
                .localizacao(localizacao)
                .build();
        
        user = userRepository.save(user);

        Vendedor vendedor = null;
        if (request.isRegistarComoVendedor()) {
            vendedor = Vendedor.builder()
                    .nome(request.getNome())
                    .email(request.getEmail())
                    .telemovel(request.getTelemovel())
                    .localizacao(localizacao)
                    .user(user)
                    .build();
            
            vendedor = vendedorRepository.save(vendedor);

            if (request.getCategorias() != null && !request.getCategorias().isEmpty()) {
                for (Integer idCategoria : request.getCategorias()) {
                    Categoria categoria = categoriaRepository.findById(idCategoria)
                            .orElseThrow(() -> new ResourceNotFoundException(
                                    "Categoria", "id", idCategoria));

                    VendedorCategoria vendedorCategoria = VendedorCategoria.builder()
                            .vendedor(vendedor)
                            .categoria(categoria)
                            .build();
                    
                    vendedorCategoriaRepository.save(vendedorCategoria);
                }
            }
        }

        String token = jwtService.generateToken(user);
        return buildAuthResponse(user, vendedor, token);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPalavraPasse()
                )
        );

        User user = userRepository.findByEmailWithVendedor(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador", "email", request.getEmail()));

        String token = jwtService.generateToken(user);
        return buildAuthResponse(user, user.getVendedor(), token);
    }

    private AuthResponse buildAuthResponse(User user, Vendedor vendedor, String token) {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        
        if (vendedor != null) {
            roles.add("ROLE_VENDEDOR");
        }

        return AuthResponse.builder()
                .token(token)
                .tipo("Bearer")
                .idUser(user.getIdUser())
                .nome(user.getNome())
                .email(user.getEmail())
                .isVendedor(vendedor != null)
                .idVendedor(vendedor != null ? vendedor.getIdVendedor() : null)
                .roles(roles)
                .build();
    }
}
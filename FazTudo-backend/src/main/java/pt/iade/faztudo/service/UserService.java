package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.request.UpdateUserRequest;
import pt.iade.faztudo.dto.response.*;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.model.Localizacao;
import pt.iade.faztudo.model.User;
import pt.iade.faztudo.repository.LocalizacaoRepository;
import pt.iade.faztudo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final LocalizacaoRepository localizacaoRepository;
    private final VendedorService vendedorService;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmailWithVendedor(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador", "email", email));
    }

    public UserResponse getCurrentUserProfile() {
        User user = getCurrentUser();
        return toUserResponse(user);
    }

    public UserResponse getUserById(Integer id) {
        User user = userRepository.findByIdWithLocalizacao(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilizador", "id", id));
        return toUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponse updateCurrentUser(UpdateUserRequest request) {
        User user = getCurrentUser();

        if (request.getNome() != null) {
            user.setNome(request.getNome());
        }
        if (request.getTelemovel() != null) {
            user.setTelemovel(request.getTelemovel());
        }

        if (request.getCidade() != null || request.getMorada() != null ||
            request.getLatitude() != null) {
            
            Localizacao localizacao = user.getLocalizacao();
            if (localizacao == null) {
                localizacao = new Localizacao();
            }
            
            if (request.getCidade() != null) localizacao.setCidade(request.getCidade());
            if (request.getMorada() != null) localizacao.setMorada(request.getMorada());
            if (request.getCodigoPostal() != null) localizacao.setCodigoPostal(request.getCodigoPostal());
            if (request.getLatitude() != null) localizacao.setLatitude(request.getLatitude());
            if (request.getLongitude() != null) localizacao.setLongitude(request.getLongitude());
            
            localizacao = localizacaoRepository.save(localizacao);
            user.setLocalizacao(localizacao);
        }

        user = userRepository.save(user);
        return toUserResponse(user);
    }

    public UserResponse toUserResponse(User user) {
        VendedorResponse vendedorResponse = null;
        if (user.getVendedor() != null) {
            vendedorResponse = vendedorService.toVendedorResponse(user.getVendedor());
        }

        return UserResponse.builder()
                .idUser(user.getIdUser())
                .nome(user.getNome())
                .email(user.getEmail())
                .telemovel(user.getTelemovel())
                .dataRegisto(user.getDataRegisto())
                .localizacao(toLocalizacaoResponse(user.getLocalizacao()))
                .isVendedor(user.getVendedor() != null)
                .vendedor(vendedorResponse)
                .build();
    }

    public LocalizacaoResponse toLocalizacaoResponse(Localizacao localizacao) {
        if (localizacao == null) return null;
        return LocalizacaoResponse.builder()
                .idLocalizacao(localizacao.getIdLocalizacao())
                .cidade(localizacao.getCidade())
                .morada(localizacao.getMorada())
                .codigoPostal(localizacao.getCodigoPostal())
                .latitude(localizacao.getLatitude())
                .longitude(localizacao.getLongitude())
                .build();
    }
}
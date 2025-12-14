package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.request.AvaliacaoRequest;
import pt.iade.faztudo.dto.response.*;
import pt.iade.faztudo.exception.ConflictException;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.exception.UnauthorizedException;
import pt.iade.faztudo.model.*;
import pt.iade.faztudo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final VendedorCategoriaRepository vendedorCategoriaRepository;
    private final UserService userService;

    @Transactional
    public AvaliacaoResponse criarAvaliacao(AvaliacaoRequest request) {
        User user = userService.getCurrentUser();

        VendedorCategoria vendedorCategoria = vendedorCategoriaRepository
                .findById(request.getIdVendedorCategoria())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "VendedorCategoria", "id", request.getIdVendedorCategoria()));

        if (avaliacaoRepository.existsByUserIdUserAndVendedorCategoriaIdVendedorCategoria(
                user.getIdUser(), request.getIdVendedorCategoria())) {
            throw new ConflictException("Já avaliou este vendedor nesta categoria");
        }

        Avaliacao avaliacao = Avaliacao.builder()
                .user(user)
                .vendedorCategoria(vendedorCategoria)
                .nota(request.getNota())
                .comentario(request.getComentario())
                .build();

        avaliacao = avaliacaoRepository.save(avaliacao);
        return toAvaliacaoResponse(avaliacao);
    }

    public AvaliacaoResponse getAvaliacaoById(Integer id) {
        Avaliacao avaliacao = avaliacaoRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação", "id", id));
        return toAvaliacaoResponse(avaliacao);
    }

    public List<AvaliacaoResponse> getMinhasAvaliacoes() {
        User user = userService.getCurrentUser();
        return avaliacaoRepository.findByUserIdUserOrderByDataAvaliacaoDesc(user.getIdUser())
                .stream()
                .map(this::toAvaliacaoResponse)
                .collect(Collectors.toList());
    }

    public List<AvaliacaoResponse> getAvaliacoesByVendedor(Integer idVendedor) {
        return avaliacaoRepository.findByVendedorId(idVendedor)
                .stream()
                .map(this::toAvaliacaoResponse)
                .collect(Collectors.toList());
    }

    public List<AvaliacaoResponse> getAvaliacoesByVendedorCategoria(Integer idVendedorCategoria) {
        return avaliacaoRepository
                .findByVendedorCategoriaIdVendedorCategoriaOrderByDataAvaliacaoDesc(idVendedorCategoria)
                .stream()
                .map(this::toAvaliacaoResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public AvaliacaoResponse atualizarAvaliacao(Integer id, AvaliacaoRequest request) {
        User user = userService.getCurrentUser();
        
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação", "id", id));

        if (!avaliacao.getUser().getIdUser().equals(user.getIdUser())) {
            throw new UnauthorizedException("Não tem permissão para editar esta avaliação");
        }

        avaliacao.setNota(request.getNota());
        avaliacao.setComentario(request.getComentario());

        avaliacao = avaliacaoRepository.save(avaliacao);
        return toAvaliacaoResponse(avaliacao);
    }

    @Transactional
    public void removerAvaliacao(Integer id) {
        User user = userService.getCurrentUser();
        
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação", "id", id));

        if (!avaliacao.getUser().getIdUser().equals(user.getIdUser())) {
            throw new UnauthorizedException("Não tem permissão para remover esta avaliação");
        }

        avaliacaoRepository.delete(avaliacao);
    }

    private AvaliacaoResponse toAvaliacaoResponse(Avaliacao avaliacao) {
        VendedorCategoria vc = avaliacao.getVendedorCategoria();
        
        return AvaliacaoResponse.builder()
                .idAvaliacao(avaliacao.getIdAvaliacao())
                .nota(avaliacao.getNota())
                .comentario(avaliacao.getComentario())
                .dataAvaliacao(avaliacao.getDataAvaliacao())
                .user(UserResumoResponse.builder()
                        .idUser(avaliacao.getUser().getIdUser())
                        .nome(avaliacao.getUser().getNome())
                        .build())
                .vendedor(VendedorResumoResponse.builder()
                        .idVendedor(vc.getVendedor().getIdVendedor())
                        .nome(vc.getVendedor().getNome())
                        .telemovel(vc.getVendedor().getTelemovel())
                        .build())
                .categoria(CategoriaResponse.builder()
                        .idCategoria(vc.getCategoria().getIdCategoria())
                        .nome(vc.getCategoria().getNome())
                        .build())
                .build();
    }
}
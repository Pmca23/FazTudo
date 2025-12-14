package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.request.ServicoRequest;
import pt.iade.faztudo.dto.response.*;
import pt.iade.faztudo.exception.BadRequestException;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.exception.UnauthorizedException;
import pt.iade.faztudo.model.*;
import pt.iade.faztudo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final VendedorCategoriaRepository vendedorCategoriaRepository;
    private final EstadoRepository estadoRepository;
    private final UserService userService;
    private final AvaliacaoRepository avaliacaoRepository;

    private static final String ESTADO_PENDENTE = "Pendente";
    private static final String ESTADO_EM_ANDAMENTO = "Em Andamento";
    private static final String ESTADO_CONCLUIDO = "Concluído";
    private static final String ESTADO_CANCELADO = "Cancelado";

    @Transactional
    public ServicoResponse criarServico(ServicoRequest request) {
        User user = userService.getCurrentUser();

        VendedorCategoria vendedorCategoria = vendedorCategoriaRepository
                .findById(request.getIdVendedorCategoria())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "VendedorCategoria", "id", request.getIdVendedorCategoria()));

        Estado estadoPendente = estadoRepository.findByNome(ESTADO_PENDENTE)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nome", ESTADO_PENDENTE));

        Servico servico = Servico.builder()
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .preco(request.getPreco())
                .vendedorCategoria(vendedorCategoria)
                .user(user)
                .estado(estadoPendente)
                .build();

        servico = servicoRepository.save(servico);
        return toServicoResponse(servico);
    }

    public ServicoResponse getServicoById(Integer id) {
        Servico servico = servicoRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço", "id", id));
        return toServicoResponse(servico);
    }

    public List<ServicoResponse> getMeusServicos() {
        User user = userService.getCurrentUser();
        return servicoRepository.findByUserIdUserOrderByDataPublicacaoDesc(user.getIdUser())
                .stream()
                .map(this::toServicoResponse)
                .collect(Collectors.toList());
    }

    public List<ServicoResponse> getMeusServicosComoVendedor() {
        User user = userService.getCurrentUser();
        
        if (user.getVendedor() == null) {
            throw new BadRequestException("O utilizador não é um vendedor");
        }

        return servicoRepository.findByVendedorId(user.getVendedor().getIdVendedor())
                .stream()
                .map(this::toServicoResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ServicoResponse atualizarEstado(Integer idServico, String novoEstado) {
        User user = userService.getCurrentUser();
        
        Servico servico = servicoRepository.findByIdWithDetails(idServico)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço", "id", idServico));

        boolean isCliente = servico.getUser().getIdUser().equals(user.getIdUser());
        boolean isVendedor = user.getVendedor() != null && 
                servico.getVendedorCategoria().getVendedor().getIdVendedor()
                        .equals(user.getVendedor().getIdVendedor());

        if (!isCliente && !isVendedor) {
            throw new UnauthorizedException("Não tem permissão para alterar este serviço");
        }

        Estado estado = estadoRepository.findByNome(novoEstado)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nome", novoEstado));

        servico.setEstado(estado);
        
        if (ESTADO_CONCLUIDO.equals(novoEstado)) {
            servico.setDataConclusao(LocalDateTime.now());
        }

        servico = servicoRepository.save(servico);
        return toServicoResponse(servico);
    }

    @Transactional
    public ServicoResponse cancelarServico(Integer idServico) {
        return atualizarEstado(idServico, ESTADO_CANCELADO);
    }

    @Transactional
    public ServicoResponse iniciarServico(Integer idServico) {
        return atualizarEstado(idServico, ESTADO_EM_ANDAMENTO);
    }

    @Transactional
    public ServicoResponse concluirServico(Integer idServico) {
        return atualizarEstado(idServico, ESTADO_CONCLUIDO);
    }

    private ServicoResponse toServicoResponse(Servico servico) {
        VendedorCategoria vc = servico.getVendedorCategoria();
        Vendedor vendedor = vc.getVendedor();

        Double mediaAvaliacoes = avaliacaoRepository.getMediaAvaliacoesByVendedor(vendedor.getIdVendedor());

        return ServicoResponse.builder()
                .idServico(servico.getIdServico())
                .titulo(servico.getTitulo())
                .descricao(servico.getDescricao())
                .preco(servico.getPreco())
                .dataPublicacao(servico.getDataPublicacao())
                .dataConclusao(servico.getDataConclusao())
                .estado(EstadoResponse.builder()
                        .idEstado(servico.getEstado().getIdEstado())
                        .nome(servico.getEstado().getNome())
                        .build())
                .vendedor(VendedorResumoResponse.builder()
                        .idVendedor(vendedor.getIdVendedor())
                        .nome(vendedor.getNome())
                        .telemovel(vendedor.getTelemovel())
                        .mediaAvaliacoes(mediaAvaliacoes != null ? 
                                Math.round(mediaAvaliacoes * 10.0) / 10.0 : 0.0)
                        .build())
                .categoria(CategoriaResponse.builder()
                        .idCategoria(vc.getCategoria().getIdCategoria())
                        .nome(vc.getCategoria().getNome())
                        .build())
                .cliente(UserResumoResponse.builder()
                        .idUser(servico.getUser().getIdUser())
                        .nome(servico.getUser().getNome())
                        .build())
                .build();
    }
}
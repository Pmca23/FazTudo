package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.response.*;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.model.*;
import pt.iade.faztudo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendedorCategoriaRepository vendedorCategoriaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public VendedorResponse getVendedorById(Integer id) {
        Vendedor vendedor = vendedorRepository.findByIdWithCategorias(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendedor", "id", id));
        return toVendedorResponse(vendedor);
    }

    public List<VendedorResponse> getAllVendedores() {
        return vendedorRepository.findAllWithCategorias().stream()
                .map(this::toVendedorResponse)
                .collect(Collectors.toList());
    }

    public List<VendedorResponse> getVendedoresByCategoria(Integer idCategoria) {
        return vendedorRepository.findByCategoriaId(idCategoria).stream()
                .map(this::toVendedorResponse)
                .collect(Collectors.toList());
    }

    public List<VendedorResponse> getVendedoresByCategoriaProximos(
            Integer idCategoria,
            Double userLatitude,
            Double userLongitude,
            Double raioKm) {
        
        if (raioKm == null) {
            raioKm = 50.0;
        }

        List<Vendedor> vendedores = vendedorRepository.findByCategoriaIdWithLocalizacao(idCategoria);
        final Double raioFinal = raioKm;

        return vendedores.stream()
                .map(vendedor -> {
                    VendedorResponse response = toVendedorResponse(vendedor);
                    
                    if (vendedor.getLocalizacao() != null &&
                        vendedor.getLocalizacao().getLatitude() != null &&
                        vendedor.getLocalizacao().getLongitude() != null) {
                        
                        double distancia = calcularDistancia(
                                userLatitude,
                                userLongitude,
                                vendedor.getLocalizacao().getLatitude(),
                                vendedor.getLocalizacao().getLongitude()
                        );
                        response.setDistanciaKm(Math.round(distancia * 100.0) / 100.0);
                    }
                    
                    return response;
                })
                .filter(v -> v.getDistanciaKm() == null || v.getDistanciaKm() <= raioFinal)
                .sorted(Comparator.comparing(
                        VendedorResponse::getDistanciaKm,
                        Comparator.nullsLast(Comparator.naturalOrder())
                ))
                .collect(Collectors.toList());
    }

    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return R * c;
    }

    public VendedorResponse toVendedorResponse(Vendedor vendedor) {
        Double mediaAvaliacoes = avaliacaoRepository.getMediaAvaliacoesByVendedor(vendedor.getIdVendedor());
        Long totalAvaliacoes = avaliacaoRepository.countByVendedorId(vendedor.getIdVendedor());

        List<VendedorCategoriaResponse> categoriasResponse = vendedor.getCategorias().stream()
                .map(this::toVendedorCategoriaResponse)
                .collect(Collectors.toList());

        return VendedorResponse.builder()
                .idVendedor(vendedor.getIdVendedor())
                .nome(vendedor.getNome())
                .email(vendedor.getEmail())
                .telemovel(vendedor.getTelemovel())
                .dataRegisto(vendedor.getDataRegisto())
                .localizacao(toLocalizacaoResponse(vendedor.getLocalizacao()))
                .categorias(categoriasResponse)
                .mediaAvaliacoes(mediaAvaliacoes != null ? Math.round(mediaAvaliacoes * 10.0) / 10.0 : 0.0)
                .totalAvaliacoes(totalAvaliacoes != null ? totalAvaliacoes.intValue() : 0)
                .build();
    }

    public VendedorCategoriaResponse toVendedorCategoriaResponse(VendedorCategoria vc) {
        Double media = vendedorCategoriaRepository.getMediaAvaliacoes(vc.getIdVendedorCategoria());
        Long total = vendedorCategoriaRepository.countAvaliacoes(vc.getIdVendedorCategoria());

        return VendedorCategoriaResponse.builder()
                .idVendedorCategoria(vc.getIdVendedorCategoria())
                .categoria(toCategoriaResponse(vc.getCategoria()))
                .descricao(vc.getDescricao())
                .dataRegisto(vc.getDataRegisto())
                .mediaAvaliacoes(media != null ? Math.round(media * 10.0) / 10.0 : 0.0)
                .totalAvaliacoes(total != null ? total.intValue() : 0)
                .build();
    }

    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        if (categoria == null) return null;
        return CategoriaResponse.builder()
                .idCategoria(categoria.getIdCategoria())
                .nome(categoria.getNome())
                .build();
    }

    private LocalizacaoResponse toLocalizacaoResponse(Localizacao localizacao) {
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
package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.response.CategoriaResponse;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.model.Categoria;
import pt.iade.faztudo.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaResponse> getAllCategorias() {
        return categoriaRepository.findAllByOrderByNomeAsc().stream()
                .map(this::toCategoriaResponse)
                .collect(Collectors.toList());
    }

    public CategoriaResponse getCategoriaById(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", id));
        return toCategoriaResponse(categoria);
    }

    public List<CategoriaResponse> searchCategorias(String termo) {
        return categoriaRepository.findByNomeContainingIgnoreCase(termo).stream()
                .map(this::toCategoriaResponse)
                .collect(Collectors.toList());
    }

    private CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return CategoriaResponse.builder()
                .idCategoria(categoria.getIdCategoria())
                .nome(categoria.getNome())
                .build();
    }
}
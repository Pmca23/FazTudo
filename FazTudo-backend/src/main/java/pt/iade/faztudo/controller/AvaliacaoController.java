package pt.iade.faztudo.controller;

import pt.iade.faztudo.dto.request.AvaliacaoRequest;
import pt.iade.faztudo.dto.response.ApiResponse;
import pt.iade.faztudo.dto.response.AvaliacaoResponse;
import pt.iade.faztudo.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<AvaliacaoResponse> criarAvaliacao(@Valid @RequestBody AvaliacaoRequest request) {
        return ResponseEntity.ok(avaliacaoService.criarAvaliacao(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> getAvaliacaoById(@PathVariable Integer id) {
        return ResponseEntity.ok(avaliacaoService.getAvaliacaoById(id));
    }

    @GetMapping("/minhas")
    public ResponseEntity<List<AvaliacaoResponse>> getMinhasAvaliacoes() {
        return ResponseEntity.ok(avaliacaoService.getMinhasAvaliacoes());
    }

    @GetMapping("/vendedor-categoria/{idVendedorCategoria}")
    public ResponseEntity<List<AvaliacaoResponse>> getAvaliacoesByVendedorCategoria(
            @PathVariable Integer idVendedorCategoria) {
        return ResponseEntity.ok(avaliacaoService.getAvaliacoesByVendedorCategoria(idVendedorCategoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponse> atualizarAvaliacao(
            @PathVariable Integer id,
            @Valid @RequestBody AvaliacaoRequest request) {
        return ResponseEntity.ok(avaliacaoService.atualizarAvaliacao(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> removerAvaliacao(@PathVariable Integer id) {
        avaliacaoService.removerAvaliacao(id);
        return ResponseEntity.ok(ApiResponse.success("Avaliação removida com sucesso"));
    }
}
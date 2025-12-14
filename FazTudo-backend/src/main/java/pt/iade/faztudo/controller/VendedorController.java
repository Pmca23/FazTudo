package pt.iade.faztudo.controller;

import pt.iade.faztudo.dto.response.AvaliacaoResponse;
import pt.iade.faztudo.dto.response.VendedorResponse;
import pt.iade.faztudo.service.AvaliacaoService;
import pt.iade.faztudo.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;
    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<VendedorResponse>> getAllVendedores() {
        return ResponseEntity.ok(vendedorService.getAllVendedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorResponse> getVendedorById(@PathVariable Integer id) {
        return ResponseEntity.ok(vendedorService.getVendedorById(id));
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<VendedorResponse>> getVendedoresByCategoria(
            @PathVariable Integer idCategoria) {
        return ResponseEntity.ok(vendedorService.getVendedoresByCategoria(idCategoria));
    }

    @GetMapping("/categoria/{idCategoria}/proximos")
    public ResponseEntity<List<VendedorResponse>> getVendedoresProximos(
            @PathVariable Integer idCategoria,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam(required = false, defaultValue = "50") Double raioKm) {
        return ResponseEntity.ok(vendedorService.getVendedoresByCategoriaProximos(
                idCategoria, latitude, longitude, raioKm));
    }

    @GetMapping("/{id}/avaliacoes")
    public ResponseEntity<List<AvaliacaoResponse>> getAvaliacoesByVendedor(@PathVariable Integer id) {
        return ResponseEntity.ok(avaliacaoService.getAvaliacoesByVendedor(id));
    }
}
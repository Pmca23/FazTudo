package pt.iade.faztudo.controller;

import pt.iade.faztudo.dto.response.CategoriaResponse;
import pt.iade.faztudo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoriaResponse>> searchCategorias(@RequestParam String termo) {
        return ResponseEntity.ok(categoriaService.searchCategorias(termo));
    }
}
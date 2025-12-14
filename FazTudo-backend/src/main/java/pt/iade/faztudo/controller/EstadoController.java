package pt.iade.faztudo.controller;

import pt.iade.faztudo.dto.response.EstadoResponse;
import pt.iade.faztudo.service.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<EstadoResponse>> getAllEstados() {
        return ResponseEntity.ok(estadoService.getAllEstados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoResponse> getEstadoById(@PathVariable Integer id) {
        return ResponseEntity.ok(estadoService.getEstadoById(id));
    }
}
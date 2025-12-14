package pt.iade.faztudo.controller;

import pt.iade.faztudo.dto.request.ServicoRequest;
import pt.iade.faztudo.dto.response.ServicoResponse;
import pt.iade.faztudo.service.ServicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoResponse> criarServico(@Valid @RequestBody ServicoRequest request) {
        return ResponseEntity.ok(servicoService.criarServico(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponse> getServicoById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.getServicoById(id));
    }

    @GetMapping("/meus")
    public ResponseEntity<List<ServicoResponse>> getMeusServicos() {
        return ResponseEntity.ok(servicoService.getMeusServicos());
    }

    @GetMapping("/meus/vendedor")
    public ResponseEntity<List<ServicoResponse>> getMeusServicosComoVendedor() {
        return ResponseEntity.ok(servicoService.getMeusServicosComoVendedor());
    }

    @PatchMapping("/{id}/iniciar")
    public ResponseEntity<ServicoResponse> iniciarServico(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.iniciarServico(id));
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<ServicoResponse> concluirServico(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.concluirServico(id));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<ServicoResponse> cancelarServico(@PathVariable Integer id) {
        return ResponseEntity.ok(servicoService.cancelarServico(id));
    }
}
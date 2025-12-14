package pt.iade.faztudo.service;

import pt.iade.faztudo.dto.response.EstadoResponse;
import pt.iade.faztudo.exception.ResourceNotFoundException;
import pt.iade.faztudo.model.Estado;
import pt.iade.faztudo.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public List<EstadoResponse> getAllEstados() {
        return estadoRepository.findAll().stream()
                .map(this::toEstadoResponse)
                .collect(Collectors.toList());
    }

    public EstadoResponse getEstadoById(Integer id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "id", id));
        return toEstadoResponse(estado);
    }

    private EstadoResponse toEstadoResponse(Estado estado) {
        return EstadoResponse.builder()
                .idEstado(estado.getIdEstado())
                .nome(estado.getNome())
                .build();
    }
}
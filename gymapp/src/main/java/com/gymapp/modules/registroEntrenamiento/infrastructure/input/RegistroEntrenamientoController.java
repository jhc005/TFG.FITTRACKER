package com.gymapp.modules.registroEntrenamiento.infrastructure.input;

import com.gymapp.modules.registroEntrenamiento.application.RegistroEntrenamientoUseCase;
import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoRequest;
import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoResponse;
import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registros")
@RequiredArgsConstructor
public class RegistroEntrenamientoController {

    private final RegistroEntrenamientoUseCase registroEntrenamientoUseCase;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RegistroEntrenamientoResponse>> findByUsuarioId(@PathVariable String usuarioId) {
        List<RegistroEntrenamientoResponse> response = registroEntrenamientoUseCase.findByUsuarioId(usuarioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{usuarioId}/ejercicio/{ejercicioId}")
    public ResponseEntity<List<RegistroEntrenamientoResponse>> findByUsuarioIdAndEjercicioId(
            @PathVariable String usuarioId,
            @PathVariable Integer ejercicioId) {
        List<RegistroEntrenamientoResponse> response = registroEntrenamientoUseCase
                .findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RegistroEntrenamientoResponse> save(@Valid @RequestBody RegistroEntrenamientoRequest request) {
        RegistroEntrenamiento saved = registroEntrenamientoUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        registroEntrenamientoUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private RegistroEntrenamiento toDomain(RegistroEntrenamientoRequest request) {
        return RegistroEntrenamiento.builder()
                .usuarioId(request.getUsuarioId())
                .ejercicioId(request.getEjercicioId())
                .pesoLevantado(request.getPesoLevantado())
                .build();
    }

    private RegistroEntrenamientoResponse toResponse(RegistroEntrenamiento domain) {
        return RegistroEntrenamientoResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .ejercicioId(domain.getEjercicioId())
                .pesoLevantado(domain.getPesoLevantado())
                .fecha(domain.getFecha())
                .build();
    }
}

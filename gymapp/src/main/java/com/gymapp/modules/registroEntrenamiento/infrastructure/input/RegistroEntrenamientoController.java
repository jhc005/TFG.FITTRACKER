package com.gymapp.modules.registroEntrenamiento.infrastructure.input;

import com.gymapp.modules.registroEntrenamiento.application.RegistroEntrenamientoService;
import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoRequest;
import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoResponse;
import com.gymapp.modules.registroEntrenamiento.infrastructure.mapper.RegistroEntrenamientoMapper;
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

    private final RegistroEntrenamientoService registroEntrenamientoService;
    private final RegistroEntrenamientoMapper registroEntrenamientoMapper;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RegistroEntrenamientoResponse>> findByUsuarioId(
            @PathVariable String usuarioId) {

        List<RegistroEntrenamientoResponse> response = registroEntrenamientoService
                .findByUsuarioId(usuarioId)
                .stream()
                .map(registroEntrenamientoMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{usuarioId}/ejercicio/{ejercicioId}")
    public ResponseEntity<List<RegistroEntrenamientoResponse>> findByUsuarioIdAndEjercicioId(
            @PathVariable String usuarioId,
            @PathVariable Integer ejercicioId) {

        List<RegistroEntrenamientoResponse> response = registroEntrenamientoService
                .findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId)
                .stream()
                .map(registroEntrenamientoMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RegistroEntrenamientoResponse> save(
            @Valid @RequestBody RegistroEntrenamientoRequest request) {

        RegistroEntrenamiento domain = registroEntrenamientoMapper.toDomain(request);
        RegistroEntrenamiento saved = registroEntrenamientoService.save(domain);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registroEntrenamientoMapper.toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        registroEntrenamientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
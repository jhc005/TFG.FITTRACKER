package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.ActividadDiaria;
import com.gymapp.domain.port.in.ActividadDiariaUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.ActividadDiariaRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.ActividadDiariaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/actividad-diaria")
@RequiredArgsConstructor
public class ActividadDiariaController {

    private final ActividadDiariaUseCase actividadDiariaUseCase;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ActividadDiariaResponse>> findByUsuarioId(@PathVariable String usuarioId) {
        List<ActividadDiariaResponse> response = actividadDiariaUseCase.findByUsuarioId(usuarioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ActividadDiariaResponse> save(@Valid @RequestBody ActividadDiariaRequest request) {
        ActividadDiaria saved = actividadDiariaUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDiariaResponse> update(@PathVariable Integer id, @Valid @RequestBody ActividadDiariaRequest request) {
        ActividadDiaria updated = actividadDiariaUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        actividadDiariaUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ActividadDiaria toDomain(ActividadDiariaRequest request) {
        return ActividadDiaria.builder()
                .usuarioId(request.getUsuarioId())
                .pasos(request.getPasos())
                .kmRecorridos(request.getKmRecorridos())
                .caloriasGastadas(request.getCaloriasGastadas())
                .build();
    }

    private ActividadDiariaResponse toResponse(ActividadDiaria domain) {
        return ActividadDiariaResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .pasos(domain.getPasos())
                .kmRecorridos(domain.getKmRecorridos())
                .caloriasGastadas(domain.getCaloriasGastadas())
                .fecha(domain.getFecha())
                .build();
    }
}

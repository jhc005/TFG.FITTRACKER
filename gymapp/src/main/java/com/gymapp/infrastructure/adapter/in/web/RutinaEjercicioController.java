package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.RutinaEjercicio;
import com.gymapp.domain.port.in.RutinaEjercicioUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.RutinaEjercicioRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.RutinaEjercicioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rutina-ejercicios")
@RequiredArgsConstructor
public class RutinaEjercicioController {

    private final RutinaEjercicioUseCase rutinaEjercicioUseCase;

    @GetMapping("/rutina/{rutinaId}")
    public ResponseEntity<List<RutinaEjercicioResponse>> findByRutinaId(@PathVariable Integer rutinaId) {
        List<RutinaEjercicioResponse> response = rutinaEjercicioUseCase.findByRutinaId(rutinaId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RutinaEjercicioResponse> save(@Valid @RequestBody RutinaEjercicioRequest request) {
        RutinaEjercicio saved = rutinaEjercicioUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaEjercicioResponse> update(@PathVariable Integer id, @Valid @RequestBody RutinaEjercicioRequest request) {
        RutinaEjercicio updated = rutinaEjercicioUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rutinaEjercicioUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private RutinaEjercicio toDomain(RutinaEjercicioRequest request) {
        return RutinaEjercicio.builder()
                .rutinaId(request.getRutinaId())
                .ejercicioId(request.getEjercicioId())
                .series(request.getSeries())
                .repeticiones(request.getRepeticiones())
                .build();
    }

    private RutinaEjercicioResponse toResponse(RutinaEjercicio domain) {
        return RutinaEjercicioResponse.builder()
                .id(domain.getId())
                .rutinaId(domain.getRutinaId())
                .ejercicioId(domain.getEjercicioId())
                .series(domain.getSeries())
                .repeticiones(domain.getRepeticiones())
                .build();
    }
}

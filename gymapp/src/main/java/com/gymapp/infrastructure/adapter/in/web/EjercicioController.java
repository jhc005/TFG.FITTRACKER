package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.Ejercicio;
import com.gymapp.domain.port.in.EjercicioUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.EjercicioRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.EjercicioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ejercicios")
@RequiredArgsConstructor
public class EjercicioController {

    private final EjercicioUseCase ejercicioUseCase;

    @GetMapping
    public ResponseEntity<List<EjercicioResponse>> findAll() {
        List<EjercicioResponse> response = ejercicioUseCase.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioResponse> findById(@PathVariable Integer id) {
        return ejercicioUseCase.findById(id)
                .map(e -> ResponseEntity.ok(toResponse(e)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EjercicioResponse> save(@Valid @RequestBody EjercicioRequest request) {
        Ejercicio saved = ejercicioUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjercicioResponse> update(@PathVariable Integer id, @Valid @RequestBody EjercicioRequest request) {
        Ejercicio updated = ejercicioUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ejercicioUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Ejercicio toDomain(EjercicioRequest request) {
        return Ejercicio.builder()
                .nombre(request.getNombre())
                .videoUrl(request.getVideoUrl())
                .descripcion(request.getDescripcion())
                .build();
    }

    private EjercicioResponse toResponse(Ejercicio domain) {
        return EjercicioResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .videoUrl(domain.getVideoUrl())
                .descripcion(domain.getDescripcion())
                .build();
    }
}

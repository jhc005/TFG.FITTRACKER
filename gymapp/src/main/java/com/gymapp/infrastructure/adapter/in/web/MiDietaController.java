package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.MiDieta;
import com.gymapp.domain.port.in.MiDietaUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.MiDietaRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.MiDietaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mi-dieta")
@RequiredArgsConstructor
public class MiDietaController {

    private final MiDietaUseCase miDietaUseCase;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MiDietaResponse>> findByUsuarioId(@PathVariable String usuarioId) {
        List<MiDietaResponse> response = miDietaUseCase.findByUsuarioId(usuarioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MiDietaResponse> save(@Valid @RequestBody MiDietaRequest request) {
        MiDieta saved = miDietaUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        miDietaUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private MiDieta toDomain(MiDietaRequest request) {
        return MiDieta.builder()
                .usuarioId(request.getUsuarioId())
                .recetaId(request.getRecetaId())
                .diaSemana(request.getDiaSemana())
                .build();
    }

    private MiDietaResponse toResponse(MiDieta domain) {
        return MiDietaResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .recetaId(domain.getRecetaId())
                .diaSemana(domain.getDiaSemana())
                .build();
    }
}

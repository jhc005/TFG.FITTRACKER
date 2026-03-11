package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.Rutina;
import com.gymapp.domain.port.in.RutinaUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.RutinaRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.RutinaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rutinas")
@RequiredArgsConstructor
public class RutinaController {

    private final RutinaUseCase rutinaUseCase;

    @GetMapping
    public ResponseEntity<List<RutinaResponse>> findAll() {
        List<RutinaResponse> response = rutinaUseCase.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaResponse> findById(@PathVariable Integer id) {
        return rutinaUseCase.findById(id)
                .map(r -> ResponseEntity.ok(toResponse(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RutinaResponse>> findByUsuarioId(@PathVariable String usuarioId) {
        List<RutinaResponse> response = rutinaUseCase.findByUsuarioId(usuarioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RutinaResponse> save(@Valid @RequestBody RutinaRequest request) {
        Rutina saved = rutinaUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaResponse> update(@PathVariable Integer id, @Valid @RequestBody RutinaRequest request) {
        Rutina updated = rutinaUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rutinaUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Rutina toDomain(RutinaRequest request) {
        return Rutina.builder()
                .nombre(request.getNombre())
                .nivel(request.getNivel())
                .esPersonalizada(request.getEsPersonalizada())
                .creadoPor(request.getCreadoPor())
                .build();
    }

    private RutinaResponse toResponse(Rutina domain) {
        return RutinaResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .nivel(domain.getNivel())
                .esPersonalizada(domain.getEsPersonalizada())
                .creadoPor(domain.getCreadoPor())
                .build();
    }
}

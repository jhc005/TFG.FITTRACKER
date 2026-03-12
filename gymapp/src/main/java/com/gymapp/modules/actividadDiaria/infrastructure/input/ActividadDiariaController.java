package com.gymapp.modules.actividadDiaria.infrastructure.input;

import com.gymapp.modules.actividadDiaria.application.ActividadDiariaService;
import com.gymapp.modules.actividadDiaria.application.dto.ActividadDiariaRequest;
import com.gymapp.modules.actividadDiaria.application.dto.ActividadDiariaResponse;
import com.gymapp.modules.actividadDiaria.infrastructure.mapper.ActividadDiariaMapper;
import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;

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

    private final ActividadDiariaService actividadDiariaService;
    private final ActividadDiariaMapper actividadDiariaMapper;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ActividadDiariaResponse>> findByUsuarioId(@PathVariable String usuarioId) {

        List<ActividadDiariaResponse> response = actividadDiariaService
                .findByUsuarioId(usuarioId)
                .stream()
                .map(actividadDiariaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ActividadDiariaResponse> save(
            @Valid @RequestBody ActividadDiariaRequest request) {

        ActividadDiaria domain = actividadDiariaMapper.toDomain(request);

        ActividadDiaria saved = actividadDiariaService.save(domain);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(actividadDiariaMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDiariaResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody ActividadDiariaRequest request) {

        ActividadDiaria domain = actividadDiariaMapper.toDomain(request);

        ActividadDiaria updated = actividadDiariaService.update(id, domain);

        return ResponseEntity.ok(
                actividadDiariaMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        actividadDiariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
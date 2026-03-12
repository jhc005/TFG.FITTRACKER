package com.gymapp.modules.receta.infrastructure.input;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.receta.application.RecetaService;
import com.gymapp.modules.receta.application.dto.RecetaRequest;
import com.gymapp.modules.receta.application.dto.RecetaResponse;
import com.gymapp.modules.receta.infrastructure.mapper.RecetaMapper;
import com.gymapp.modules.receta.domain.model.Receta;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recetas")
@RequiredArgsConstructor
public class RecetaController {

    private final RecetaService recetaService;
    private final RecetaMapper recetaMapper;

    @GetMapping
    public ResponseEntity<List<RecetaResponse>> findAll() {
        List<RecetaResponse> response = recetaService.findAll()
                .stream()
                .map(recetaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaResponse> findById(@PathVariable Integer id) {
        return recetaService.findById(id)
                .map(recetaMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivo}")
    public ResponseEntity<List<RecetaResponse>> findByObjetivo(@PathVariable ObjetivoReceta objetivo) {
        List<RecetaResponse> response = recetaService.findByObjetivo(objetivo)
                .stream()
                .map(recetaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RecetaResponse> save(@Valid @RequestBody RecetaRequest request) {
        Receta domain = recetaMapper.toDomain(request);
        Receta saved = recetaService.save(domain);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recetaMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaResponse> update(@PathVariable Integer id,
                                                 @Valid @RequestBody RecetaRequest request) {
        Receta domain = recetaMapper.toDomain(request);
        Receta updated = recetaService.update(id, domain);
        return ResponseEntity.ok(recetaMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recetaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
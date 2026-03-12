package com.gymapp.modules.ejercicio.infrastructure.input;

import com.gymapp.modules.ejercicio.application.EjercicioService;
import com.gymapp.modules.ejercicio.application.dto.EjercicioRequest;
import com.gymapp.modules.ejercicio.application.dto.EjercicioResponse;
import com.gymapp.modules.ejercicio.infrastructure.mapper.EjercicioMapper;
import com.gymapp.modules.ejercicio.domain.model.Ejercicio;

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

    private final EjercicioService ejercicioService;
    private final EjercicioMapper ejercicioMapper;

    @GetMapping
    public ResponseEntity<List<EjercicioResponse>> findAll() {

        List<EjercicioResponse> response = ejercicioService.findAll()
                .stream()
                .map(ejercicioMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioResponse> findById(@PathVariable Integer id) {

        return ejercicioService.findById(id)
                .map(ejercicioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EjercicioResponse> save(
            @Valid @RequestBody EjercicioRequest request) {

        Ejercicio domain = ejercicioMapper.toDomain(request);

        Ejercicio saved = ejercicioService.save(domain);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ejercicioMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjercicioResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody EjercicioRequest request) {

        Ejercicio domain = ejercicioMapper.toDomain(request);

        Ejercicio updated = ejercicioService.update(id, domain);

        return ResponseEntity.ok(
                ejercicioMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ejercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
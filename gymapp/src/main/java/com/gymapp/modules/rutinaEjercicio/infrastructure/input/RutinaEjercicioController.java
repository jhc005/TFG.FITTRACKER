package com.gymapp.modules.rutinaEjercicio.infrastructure.input;

import com.gymapp.modules.rutinaEjercicio.application.RutinaEjercicioService;
import com.gymapp.modules.rutinaEjercicio.application.dto.RutinaEjercicioRequest;
import com.gymapp.modules.rutinaEjercicio.application.dto.RutinaEjercicioResponse;
import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;
import com.gymapp.modules.rutinaEjercicio.infrastructure.mapper.RutinaEjercicioMapper;

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

    private final RutinaEjercicioService rutinaEjercicioService;
    private final RutinaEjercicioMapper rutinaEjercicioMapper;

    @GetMapping("/rutina/{rutinaId}")
    public ResponseEntity<List<RutinaEjercicioResponse>> findByRutinaId(@PathVariable Integer rutinaId) {
        List<RutinaEjercicioResponse> response = rutinaEjercicioService.findByRutinaId(rutinaId)
                .stream()
                .map(rutinaEjercicioMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RutinaEjercicioResponse> save(@Valid @RequestBody RutinaEjercicioRequest request) {
        RutinaEjercicio domain = rutinaEjercicioMapper.toDomain(request);
        RutinaEjercicio saved = rutinaEjercicioService.save(domain);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rutinaEjercicioMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaEjercicioResponse> update(@PathVariable Integer id,
                                                          @Valid @RequestBody RutinaEjercicioRequest request) {
        RutinaEjercicio domain = rutinaEjercicioMapper.toDomain(request);
        RutinaEjercicio updated = rutinaEjercicioService.update(id, domain);

        return ResponseEntity.ok(rutinaEjercicioMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rutinaEjercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.gymapp.modules.rutina.infrastructure.input;

import com.gymapp.modules.rutina.application.RutinaService;
import com.gymapp.modules.rutina.application.dto.RutinaRequest;
import com.gymapp.modules.rutina.application.dto.RutinaResponse;
import com.gymapp.modules.rutina.domain.model.Rutina;
import com.gymapp.modules.rutina.infrastructure.mapper.RutinaMapper;

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

    private final RutinaService rutinaService;
    private final RutinaMapper rutinaMapper;

    @GetMapping
    public ResponseEntity<List<RutinaResponse>> findAll() {
        List<RutinaResponse> response = rutinaService.findAll()
                .stream()
                .map(rutinaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaResponse> findById(@PathVariable Integer id) {
        return rutinaService.findById(id)
                .map(rutinaMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<RutinaResponse>> findByUsuarioId(@PathVariable String usuarioId) {
        List<RutinaResponse> response = rutinaService.findByUsuarioId(usuarioId)
                .stream()
                .map(rutinaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RutinaResponse> save(@Valid @RequestBody RutinaRequest request) {
        Rutina domain = rutinaMapper.toDomain(request);
        Rutina saved = rutinaService.save(domain);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rutinaMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaResponse> update(@PathVariable Integer id,
            @Valid @RequestBody RutinaRequest request) {
        Rutina domain = rutinaMapper.toDomain(request);
        Rutina updated = rutinaService.update(id, domain);

        return ResponseEntity.ok(rutinaMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rutinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
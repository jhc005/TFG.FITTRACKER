package com.gymapp.modules.miDieta.infrastructure.input;

import com.gymapp.modules.miDieta.application.MiDietaService;
import com.gymapp.modules.miDieta.application.dto.MiDietaRequest;
import com.gymapp.modules.miDieta.application.dto.MiDietaResponse;
import com.gymapp.modules.miDieta.infrastructure.mapper.MiDietaMapper;
import com.gymapp.modules.miDieta.domain.model.MiDieta;

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

    private final MiDietaService miDietaService;
    private final MiDietaMapper miDietaMapper;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MiDietaResponse>> findByUsuarioId(@PathVariable String usuarioId) {

        List<MiDietaResponse> response = miDietaService.findByUsuarioId(usuarioId)
                .stream()
                .map(miDietaMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<MiDietaResponse> save(
            @Valid @RequestBody MiDietaRequest request) {

        MiDieta domain = miDietaMapper.toDomain(request);

        MiDieta saved = miDietaService.save(domain);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(miDietaMapper.toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        miDietaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
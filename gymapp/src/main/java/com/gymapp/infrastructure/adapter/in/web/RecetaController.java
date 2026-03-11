package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.Receta;
import com.gymapp.domain.model.enums.ObjetivoReceta;
import com.gymapp.domain.port.in.RecetaUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.RecetaRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.RecetaResponse;
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

    private final RecetaUseCase recetaUseCase;

    @GetMapping
    public ResponseEntity<List<RecetaResponse>> findAll() {
        List<RecetaResponse> response = recetaUseCase.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaResponse> findById(@PathVariable Integer id) {
        return recetaUseCase.findById(id)
                .map(r -> ResponseEntity.ok(toResponse(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivo}")
    public ResponseEntity<List<RecetaResponse>> findByObjetivo(@PathVariable ObjetivoReceta objetivo) {
        List<RecetaResponse> response = recetaUseCase.findByObjetivo(objetivo).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RecetaResponse> save(@Valid @RequestBody RecetaRequest request) {
        Receta saved = recetaUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaResponse> update(@PathVariable Integer id, @Valid @RequestBody RecetaRequest request) {
        Receta updated = recetaUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recetaUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Receta toDomain(RecetaRequest request) {
        return Receta.builder()
                .nombre(request.getNombre())
                .tipo(request.getTipo())
                .objetivoApto(request.getObjetivoApto())
                .proteinas(request.getProteinas())
                .carbohidratos(request.getCarbohidratos())
                .grasas(request.getGrasas())
                .calorias_totales(request.getCalorias_totales())
                .instrucciones(request.getInstrucciones())
                .fotoUrl(request.getFotoUrl())
                .build();
    }

    private RecetaResponse toResponse(Receta domain) {
        return RecetaResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .tipo(domain.getTipo())
                .objetivoApto(domain.getObjetivoApto())
                .proteinas(domain.getProteinas())
                .carbohidratos(domain.getCarbohidratos())
                .grasas(domain.getGrasas())
                .calorias_totales(domain.getCalorias_totales())
                .instrucciones(domain.getInstrucciones())
                .fotoUrl(domain.getFotoUrl())
                .build();
    }
}

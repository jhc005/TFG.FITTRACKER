package com.gymapp.infrastructure.adapter.in.web;

import com.gymapp.domain.model.Usuario;
import com.gymapp.domain.port.in.UsuarioUseCase;
import com.gymapp.infrastructure.adapter.in.web.dto.UsuarioRequest;
import com.gymapp.infrastructure.adapter.in.web.dto.UsuarioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<UsuarioResponse> response = usuarioUseCase.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable String id) {
        return usuarioUseCase.findById(id)
                .map(u -> ResponseEntity.ok(toResponse(u)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest request) {
        Usuario saved = usuarioUseCase.save(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable String id, @Valid @RequestBody UsuarioRequest request) {
        Usuario updated = usuarioUseCase.update(id, toDomain(request));
        return ResponseEntity.ok(toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usuarioUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Usuario toDomain(UsuarioRequest request) {
        return Usuario.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .fotoUrl(request.getFotoUrl())
                .rol(request.getRol())
                .peso(request.getPeso())
                .altura(request.getAltura())
                .edad(request.getEdad())
                .sexo(request.getSexo())
                .actividadDiaria(request.getActividadDiaria())
                .objetivo(request.getObjetivo())
                .caloriasObjetivo(request.getCaloriasObjetivo())
                .build();
    }

    private UsuarioResponse toResponse(Usuario domain) {
        return UsuarioResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .fotoUrl(domain.getFotoUrl())
                .rol(domain.getRol())
                .peso(domain.getPeso())
                .altura(domain.getAltura())
                .edad(domain.getEdad())
                .sexo(domain.getSexo())
                .actividadDiaria(domain.getActividadDiaria())
                .objetivo(domain.getObjetivo())
                .caloriasObjetivo(domain.getCaloriasObjetivo())
                .fechaRegistro(domain.getFechaRegistro())
                .build();
    }
}

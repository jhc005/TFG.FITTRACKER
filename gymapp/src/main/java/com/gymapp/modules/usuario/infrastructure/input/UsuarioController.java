package com.gymapp.modules.usuario.infrastructure.input;

import com.gymapp.modules.usuario.application.UsuarioService;
import com.gymapp.modules.usuario.application.dto.UsuarioRequest;
import com.gymapp.modules.usuario.application.dto.UsuarioResponse;
import com.gymapp.modules.usuario.domain.model.Usuario;
import com.gymapp.modules.usuario.infrastructure.mapper.UsuarioMapper;

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

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<UsuarioResponse> response = usuarioService.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable String id) {
        return usuarioService.findById(id)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@Valid @RequestBody UsuarioRequest request) {
        Usuario domain = usuarioMapper.toDomain(request);
        Usuario saved = usuarioService.save(domain);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioMapper.toResponse(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable String id,
                                                  @Valid @RequestBody UsuarioRequest request) {
        Usuario domain = usuarioMapper.toDomain(request);
        Usuario updated = usuarioService.update(id, domain);

        return ResponseEntity.ok(usuarioMapper.toResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
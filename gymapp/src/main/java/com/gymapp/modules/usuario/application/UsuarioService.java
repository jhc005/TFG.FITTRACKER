package com.gymapp.modules.usuario.application;

import com.gymapp.modules.usuario.domain.model.Usuario;
import com.gymapp.modules.usuario.domain.outport.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public Optional<Usuario> findById(String id) {
        return usuarioRepositoryPort.findById(id);
    }

    public List<Usuario> findAll() {
        return usuarioRepositoryPort.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    public Usuario update(String id, Usuario usuario) {
        return usuarioRepositoryPort.update(id, usuario);
    }

    public void delete(String id) {
        usuarioRepositoryPort.delete(id);
    }
}

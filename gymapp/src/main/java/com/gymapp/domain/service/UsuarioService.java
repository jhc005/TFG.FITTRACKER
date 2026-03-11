package com.gymapp.domain.service;

import com.gymapp.domain.model.Usuario;
import com.gymapp.domain.port.in.UsuarioUseCase;
import com.gymapp.domain.port.out.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public Optional<Usuario> findById(String id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositoryPort.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Usuario update(String id, Usuario usuario) {
        return usuarioRepositoryPort.update(id, usuario);
    }

    @Override
    public void delete(String id) {
        usuarioRepositoryPort.delete(id);
    }
}

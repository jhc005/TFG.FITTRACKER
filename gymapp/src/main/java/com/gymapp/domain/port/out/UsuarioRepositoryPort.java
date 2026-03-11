package com.gymapp.domain.port.out;

import com.gymapp.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Optional<Usuario> findById(String id);
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario update(String id, Usuario usuario);
    void delete(String id);
}

package com.gymapp.modules.usuario.domain.outport;

import java.util.List;
import java.util.Optional;

import com.gymapp.modules.usuario.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Optional<Usuario> findById(String id);
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario update(String id, Usuario usuario);
    void delete(String id);
}

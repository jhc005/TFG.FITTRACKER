package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.Usuario;
import com.gymapp.domain.port.out.UsuarioRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.UsuarioJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.UsuarioMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public Optional<Usuario> findById(String id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioJpaEntity entity = mapper.toJpaEntity(usuario);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Usuario update(String id, Usuario usuario) {
        usuario.setId(id);
        UsuarioJpaEntity entity = mapper.toJpaEntity(usuario);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

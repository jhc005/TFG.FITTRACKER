package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.Rutina;
import com.gymapp.domain.port.out.RutinaRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RutinaJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.RutinaMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.RutinaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RutinaPersistenceAdapter implements RutinaRepositoryPort {

    private final RutinaJpaRepository repository;
    private final RutinaMapper mapper;

    @Override
    public Optional<Rutina> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Rutina> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rutina> findByUsuarioId(String usuarioId) {
        return repository.findByCreadoPor(usuarioId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Rutina save(Rutina rutina) {
        RutinaJpaEntity entity = mapper.toJpaEntity(rutina);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Rutina update(Integer id, Rutina rutina) {
        rutina.setId(id);
        RutinaJpaEntity entity = mapper.toJpaEntity(rutina);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

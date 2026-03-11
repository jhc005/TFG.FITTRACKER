package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.ActividadDiaria;
import com.gymapp.domain.port.out.ActividadDiariaRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.ActividadDiariaJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.ActividadDiariaMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.ActividadDiariaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ActividadDiariaPersistenceAdapter implements ActividadDiariaRepositoryPort {

    private final ActividadDiariaJpaRepository repository;
    private final ActividadDiariaMapper mapper;

    @Override
    public List<ActividadDiaria> findByUsuarioId(String usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadDiaria save(ActividadDiaria actividad) {
        ActividadDiariaJpaEntity entity = mapper.toJpaEntity(actividad);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public ActividadDiaria update(Integer id, ActividadDiaria actividad) {
        actividad.setId(id);
        ActividadDiariaJpaEntity entity = mapper.toJpaEntity(actividad);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

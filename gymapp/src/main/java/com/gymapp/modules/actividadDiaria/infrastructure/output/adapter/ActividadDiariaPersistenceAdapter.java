package com.gymapp.modules.actividadDiaria.infrastructure.output.adapter;

import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;
import com.gymapp.modules.actividadDiaria.domain.outport.ActividadDiariaRepositoryPort;
import com.gymapp.modules.actividadDiaria.infrastructure.mapper.ActividadDiariaMapper;
import com.gymapp.modules.actividadDiaria.infrastructure.output.jpa.ActividadDiariaJpaEntity;
import com.gymapp.modules.actividadDiaria.infrastructure.output.jpa.ActividadDiariaJpaRepository;

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

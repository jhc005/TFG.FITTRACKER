package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.Receta;
import com.gymapp.domain.model.enums.ObjetivoReceta;
import com.gymapp.domain.port.out.RecetaRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RecetaJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.RecetaMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.RecetaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RecetaPersistenceAdapter implements RecetaRepositoryPort {

    private final RecetaJpaRepository repository;
    private final RecetaMapper mapper;

    @Override
    public Optional<Receta> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Receta> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Receta> findByObjetivo(ObjetivoReceta objetivo) {
        return repository.findByObjetivoApto(objetivo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Receta save(Receta receta) {
        RecetaJpaEntity entity = mapper.toJpaEntity(receta);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Receta update(Integer id, Receta receta) {
        receta.setId(id);
        RecetaJpaEntity entity = mapper.toJpaEntity(receta);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

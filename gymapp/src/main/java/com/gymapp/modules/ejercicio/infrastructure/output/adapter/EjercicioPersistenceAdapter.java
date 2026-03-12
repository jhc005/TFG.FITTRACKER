package com.gymapp.modules.ejercicio.infrastructure.output.adapter;

import com.gymapp.modules.ejercicio.domain.model.Ejercicio;
import com.gymapp.modules.ejercicio.domain.outport.EjercicioRepositoryPort;
import com.gymapp.modules.ejercicio.infrastructure.mapper.EjercicioMapper;
import com.gymapp.modules.ejercicio.infrastructure.output.jpa.EjercicioJpaEntity;
import com.gymapp.modules.ejercicio.infrastructure.output.jpa.EjercicioJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class EjercicioPersistenceAdapter implements EjercicioRepositoryPort {

    private final EjercicioJpaRepository repository;
    private final EjercicioMapper mapper;

    @Override
    public Optional<Ejercicio> findById(Integer id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Ejercicio> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Ejercicio save(Ejercicio ejercicio) {
        EjercicioJpaEntity entity = mapper.toJpaEntity(ejercicio);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Ejercicio update(Integer id, Ejercicio ejercicio) {
        ejercicio.setId(id);
        EjercicioJpaEntity entity = mapper.toJpaEntity(ejercicio);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

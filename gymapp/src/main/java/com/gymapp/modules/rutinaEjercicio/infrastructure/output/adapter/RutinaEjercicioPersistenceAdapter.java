package com.gymapp.modules.rutinaEjercicio.infrastructure.output.adapter;

import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;
import com.gymapp.modules.rutinaEjercicio.domain.outport.RutinaEjercicioRepositoryPort;
import com.gymapp.modules.rutinaEjercicio.infrastructure.mapper.RutinaEjercicioMapper;
import com.gymapp.modules.rutinaEjercicio.infrastructure.output.jpa.RutinaEjercicioJpaEntity;
import com.gymapp.modules.rutinaEjercicio.infrastructure.output.jpa.RutinaEjercicioJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RutinaEjercicioPersistenceAdapter implements RutinaEjercicioRepositoryPort {

    private final RutinaEjercicioJpaRepository repository;
    private final RutinaEjercicioMapper mapper;

    @Override
    public List<RutinaEjercicio> findByRutinaId(Integer rutinaId) {
        return repository.findByRutinaId(rutinaId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public RutinaEjercicio save(RutinaEjercicio re) {
        RutinaEjercicioJpaEntity entity = mapper.toJpaEntity(re);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public RutinaEjercicio update(Integer id, RutinaEjercicio re) {
        re.setId(id);
        RutinaEjercicioJpaEntity entity = mapper.toJpaEntity(re);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

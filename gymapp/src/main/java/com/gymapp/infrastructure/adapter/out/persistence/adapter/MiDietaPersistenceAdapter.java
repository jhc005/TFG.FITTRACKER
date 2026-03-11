package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.MiDieta;
import com.gymapp.domain.port.out.MiDietaRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.MiDietaJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.MiDietaMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.MiDietaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MiDietaPersistenceAdapter implements MiDietaRepositoryPort {

    private final MiDietaJpaRepository repository;
    private final MiDietaMapper mapper;

    @Override
    public List<MiDieta> findByUsuarioId(String usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public MiDieta save(MiDieta miDieta) {
        MiDietaJpaEntity entity = mapper.toJpaEntity(miDieta);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

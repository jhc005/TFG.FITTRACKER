package com.gymapp.infrastructure.adapter.out.persistence.adapter;

import com.gymapp.domain.model.RegistroEntrenamiento;
import com.gymapp.domain.port.out.RegistroEntrenamientoRepositoryPort;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RegistroEntrenamientoJpaEntity;
import com.gymapp.infrastructure.adapter.out.persistence.mapper.RegistroEntrenamientoMapper;
import com.gymapp.infrastructure.adapter.out.persistence.repository.RegistroEntrenamientoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RegistroEntrenamientoPersistenceAdapter implements RegistroEntrenamientoRepositoryPort {

    private final RegistroEntrenamientoJpaRepository repository;
    private final RegistroEntrenamientoMapper mapper;

    @Override
    public List<RegistroEntrenamiento> findByUsuarioId(String usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId) {
        return repository.findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public RegistroEntrenamiento save(RegistroEntrenamiento registro) {
        RegistroEntrenamientoJpaEntity entity = mapper.toJpaEntity(registro);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

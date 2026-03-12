package com.gymapp.modules.registroEntrenamiento.infrastructure.output.adapter;

import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;
import com.gymapp.modules.registroEntrenamiento.domain.output.RegistroEntrenamientoRepositoryPort;
import com.gymapp.modules.registroEntrenamiento.infrastructure.mapper.RegistroEntrenamientoMapper;
import com.gymapp.modules.registroEntrenamiento.infrastructure.output.jpa.RegistroEntrenamientoJpaEntity;
import com.gymapp.modules.registroEntrenamiento.infrastructure.output.jpa.RegistroEntrenamientoJpaRepository;

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

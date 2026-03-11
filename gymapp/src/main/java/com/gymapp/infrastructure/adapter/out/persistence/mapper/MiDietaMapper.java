package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.MiDieta;
import com.gymapp.infrastructure.adapter.out.persistence.entity.MiDietaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class MiDietaMapper {

    public MiDieta toDomain(MiDietaJpaEntity entity) {
        if (entity == null) return null;
        return MiDieta.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioId())
                .recetaId(entity.getRecetaId())
                .diaSemana(entity.getDiaSemana())
                .build();
    }

    public MiDietaJpaEntity toJpaEntity(MiDieta domain) {
        if (domain == null) return null;
        return MiDietaJpaEntity.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .recetaId(domain.getRecetaId())
                .diaSemana(domain.getDiaSemana())
                .build();
    }
}

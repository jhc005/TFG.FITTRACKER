package com.gymapp.modules.rutinaEjercicio.infrastructure.mapper;

import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;
import com.gymapp.modules.rutinaEjercicio.infrastructure.output.jpa.RutinaEjercicioJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class RutinaEjercicioMapper {

    public RutinaEjercicio toDomain(RutinaEjercicioJpaEntity entity) {
        if (entity == null) return null;
        return RutinaEjercicio.builder()
                .id(entity.getId())
                .rutinaId(entity.getRutinaId())
                .ejercicioId(entity.getEjercicioId())
                .series(entity.getSeries())
                .repeticiones(entity.getRepeticiones())
                .build();
    }

    public RutinaEjercicioJpaEntity toJpaEntity(RutinaEjercicio domain) {
        if (domain == null) return null;
        return RutinaEjercicioJpaEntity.builder()
                .id(domain.getId())
                .rutinaId(domain.getRutinaId())
                .ejercicioId(domain.getEjercicioId())
                .series(domain.getSeries())
                .repeticiones(domain.getRepeticiones())
                .build();
    }
}

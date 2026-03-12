package com.gymapp.modules.rutina.infrastructure.mapper;

import com.gymapp.modules.rutina.domain.model.Rutina;
import com.gymapp.modules.rutina.infrastructure.output.jpa.RutinaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class RutinaMapper {

    public Rutina toDomain(RutinaJpaEntity entity) {
        if (entity == null) return null;
        return Rutina.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .nivel(entity.getNivel())
                .esPersonalizada(entity.getEsPersonalizada())
                .creadoPor(entity.getCreadoPor())
                .build();
    }

    public RutinaJpaEntity toJpaEntity(Rutina domain) {
        if (domain == null) return null;
        return RutinaJpaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .nivel(domain.getNivel())
                .esPersonalizada(domain.getEsPersonalizada())
                .creadoPor(domain.getCreadoPor())
                .build();
    }
}

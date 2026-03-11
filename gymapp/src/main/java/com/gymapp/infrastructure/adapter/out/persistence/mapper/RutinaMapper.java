package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.Rutina;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RutinaJpaEntity;
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

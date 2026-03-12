package com.gymapp.modules.actividadDiaria.infrastructure.mapper;

import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;
import com.gymapp.modules.actividadDiaria.infrastructure.output.jpa.ActividadDiariaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class ActividadDiariaMapper {

    public ActividadDiaria toDomain(ActividadDiariaJpaEntity entity) {
        if (entity == null) return null;
        return ActividadDiaria.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioId())
                .pasos(entity.getPasos())
                .kmRecorridos(entity.getKmRecorridos())
                .caloriasGastadas(entity.getCaloriasGastadas())
                .fecha(entity.getFecha())
                .build();
    }

    public ActividadDiariaJpaEntity toJpaEntity(ActividadDiaria domain) {
        if (domain == null) return null;
        return ActividadDiariaJpaEntity.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .pasos(domain.getPasos())
                .kmRecorridos(domain.getKmRecorridos())
                .caloriasGastadas(domain.getCaloriasGastadas())
                .fecha(domain.getFecha())
                .build();
    }
}

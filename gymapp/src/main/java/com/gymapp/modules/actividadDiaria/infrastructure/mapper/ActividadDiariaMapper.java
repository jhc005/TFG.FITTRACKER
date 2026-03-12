package com.gymapp.modules.actividadDiaria.infrastructure.mapper;

import com.gymapp.modules.actividadDiaria.application.dto.ActividadDiariaRequest;
import com.gymapp.modules.actividadDiaria.application.dto.ActividadDiariaResponse;
import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;
import com.gymapp.modules.actividadDiaria.infrastructure.output.jpa.ActividadDiariaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class ActividadDiariaMapper {

    // Request -> Domain
    public ActividadDiaria toDomain(ActividadDiariaRequest request) {
        if (request == null) return null;

        return ActividadDiaria.builder()
                .usuarioId(request.getUsuarioId())
                .pasos(request.getPasos())
                .kmRecorridos(request.getKmRecorridos())
                .caloriasGastadas(request.getCaloriasGastadas())
                .build();
    }

    // Domain -> Response
    public ActividadDiariaResponse toResponse(ActividadDiaria domain) {
        if (domain == null) return null;

        return ActividadDiariaResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .pasos(domain.getPasos())
                .kmRecorridos(domain.getKmRecorridos())
                .caloriasGastadas(domain.getCaloriasGastadas())
                .fecha(domain.getFecha())
                .build();
    }

    // JPA -> Domain
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

    // Domain -> JPA
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
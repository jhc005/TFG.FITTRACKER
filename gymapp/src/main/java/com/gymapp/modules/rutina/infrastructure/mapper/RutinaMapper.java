package com.gymapp.modules.rutina.infrastructure.mapper;

import com.gymapp.modules.rutina.application.dto.RutinaRequest;
import com.gymapp.modules.rutina.application.dto.RutinaResponse;
import com.gymapp.modules.rutina.domain.model.Rutina;
import com.gymapp.modules.rutina.infrastructure.output.jpa.RutinaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class RutinaMapper {

    // Request -> Domain
    public Rutina toDomain(RutinaRequest request) {
        if (request == null)
            return null;

        return Rutina.builder()
                .nombre(request.getNombre())
                .nivel(request.getNivel())
                .esPersonalizada(request.getEsPersonalizada())
                .creadoPor(request.getCreadoPor())
                .build();
    }

    // Domain -> Response
    public RutinaResponse toResponse(Rutina domain) {
        if (domain == null)
            return null;

        return RutinaResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .nivel(domain.getNivel())
                .esPersonalizada(domain.getEsPersonalizada())
                .creadoPor(domain.getCreadoPor())
                .build();
    }

    // JPA -> Domain
    public Rutina toDomain(RutinaJpaEntity entity) {
        if (entity == null)
            return null;

        return Rutina.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .nivel(entity.getNivel())
                .esPersonalizada(entity.getEsPersonalizada())
                .creadoPor(entity.getCreadoPor())
                .build();
    }

    // Domain -> JPA
    public RutinaJpaEntity toJpaEntity(Rutina domain) {
        if (domain == null)
            return null;

        return RutinaJpaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .nivel(domain.getNivel())
                .esPersonalizada(domain.getEsPersonalizada())
                .creadoPor(domain.getCreadoPor())
                .build();
    }
}
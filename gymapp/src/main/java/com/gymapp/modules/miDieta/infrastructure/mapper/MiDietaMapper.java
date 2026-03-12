package com.gymapp.modules.miDieta.infrastructure.mapper;

import com.gymapp.modules.miDieta.application.dto.MiDietaRequest;
import com.gymapp.modules.miDieta.application.dto.MiDietaResponse;
import com.gymapp.modules.miDieta.domain.model.MiDieta;
import com.gymapp.modules.miDieta.infrastructure.output.jpa.MiDietaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class MiDietaMapper {

    // Request -> Domain
    public MiDieta toDomain(MiDietaRequest request) {
        if (request == null)
            return null;

        return MiDieta.builder()
                .usuarioId(request.getUsuarioId())
                .recetaId(request.getRecetaId())
                .diaSemana(request.getDiaSemana())
                .build();
    }

    // Domain -> Response
    public MiDietaResponse toResponse(MiDieta domain) {
        if (domain == null)
            return null;

        return MiDietaResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .recetaId(domain.getRecetaId())
                .diaSemana(domain.getDiaSemana())
                .build();
    }

    // JPA -> Domain
    public MiDieta toDomain(MiDietaJpaEntity entity) {
        if (entity == null)
            return null;

        return MiDieta.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioId())
                .recetaId(entity.getRecetaId())
                .diaSemana(entity.getDiaSemana())
                .build();
    }

    // Domain -> JPA
    public MiDietaJpaEntity toJpaEntity(MiDieta domain) {
        if (domain == null)
            return null;

        return MiDietaJpaEntity.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .recetaId(domain.getRecetaId())
                .diaSemana(domain.getDiaSemana())
                .build();
    }
}

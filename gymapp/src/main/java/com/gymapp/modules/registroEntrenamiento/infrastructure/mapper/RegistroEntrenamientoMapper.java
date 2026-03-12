package com.gymapp.modules.registroEntrenamiento.infrastructure.mapper;

import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoRequest;
import com.gymapp.modules.registroEntrenamiento.application.dto.RegistroEntrenamientoResponse;
import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;
import com.gymapp.modules.registroEntrenamiento.infrastructure.output.jpa.RegistroEntrenamientoJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class RegistroEntrenamientoMapper {

    // Request -> Domain
    public RegistroEntrenamiento toDomain(RegistroEntrenamientoRequest request) {
        if (request == null)
            return null;

        return RegistroEntrenamiento.builder()
                .usuarioId(request.getUsuarioId())
                .ejercicioId(request.getEjercicioId())
                .pesoLevantado(request.getPesoLevantado())
                .build();
    }

    // Domain -> Response
    public RegistroEntrenamientoResponse toResponse(RegistroEntrenamiento domain) {
        if (domain == null)
            return null;

        return RegistroEntrenamientoResponse.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .ejercicioId(domain.getEjercicioId())
                .pesoLevantado(domain.getPesoLevantado())
                .fecha(domain.getFecha())
                .build();
    }

    // JPA -> Domain
    public RegistroEntrenamiento toDomain(RegistroEntrenamientoJpaEntity entity) {
        if (entity == null)
            return null;

        return RegistroEntrenamiento.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioId())
                .ejercicioId(entity.getEjercicioId())
                .pesoLevantado(entity.getPesoLevantado())
                .fecha(entity.getFecha())
                .build();
    }

    // Domain -> JPA
    public RegistroEntrenamientoJpaEntity toJpaEntity(RegistroEntrenamiento domain) {
        if (domain == null)
            return null;

        return RegistroEntrenamientoJpaEntity.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .ejercicioId(domain.getEjercicioId())
                .pesoLevantado(domain.getPesoLevantado())
                .fecha(domain.getFecha())
                .build();
    }
}
package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.RegistroEntrenamiento;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RegistroEntrenamientoJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistroEntrenamientoMapper {

    public RegistroEntrenamiento toDomain(RegistroEntrenamientoJpaEntity entity) {
        if (entity == null) return null;
        return RegistroEntrenamiento.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuarioId())
                .ejercicioId(entity.getEjercicioId())
                .pesoLevantado(entity.getPesoLevantado())
                .fecha(entity.getFecha())
                .build();
    }

    public RegistroEntrenamientoJpaEntity toJpaEntity(RegistroEntrenamiento domain) {
        if (domain == null) return null;
        return RegistroEntrenamientoJpaEntity.builder()
                .id(domain.getId())
                .usuarioId(domain.getUsuarioId())
                .ejercicioId(domain.getEjercicioId())
                .pesoLevantado(domain.getPesoLevantado())
                .fecha(domain.getFecha())
                .build();
    }
}

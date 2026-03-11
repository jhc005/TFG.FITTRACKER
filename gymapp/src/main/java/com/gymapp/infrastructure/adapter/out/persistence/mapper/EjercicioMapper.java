package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.Ejercicio;
import com.gymapp.infrastructure.adapter.out.persistence.entity.EjercicioJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class EjercicioMapper {

    public Ejercicio toDomain(EjercicioJpaEntity entity) {
        if (entity == null) return null;
        return Ejercicio.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .videoUrl(entity.getVideoUrl())
                .descripcion(entity.getDescripcion())
                .build();
    }

    public EjercicioJpaEntity toJpaEntity(Ejercicio domain) {
        if (domain == null) return null;
        return EjercicioJpaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .videoUrl(domain.getVideoUrl())
                .descripcion(domain.getDescripcion())
                .build();
    }
}

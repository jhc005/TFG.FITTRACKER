package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.Usuario;
import com.gymapp.infrastructure.adapter.out.persistence.entity.UsuarioJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioJpaEntity entity) {
        if (entity == null) return null;
        return Usuario.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fotoUrl(entity.getFotoUrl())
                .rol(entity.getRol())
                .peso(entity.getPeso())
                .altura(entity.getAltura())
                .edad(entity.getEdad())
                .sexo(entity.getSexo())
                .actividadDiaria(entity.getActividadDiaria())
                .objetivo(entity.getObjetivo())
                .caloriasObjetivo(entity.getCaloriasObjetivo())
                .fechaRegistro(entity.getFechaRegistro())
                .build();
    }

    public UsuarioJpaEntity toJpaEntity(Usuario domain) {
        if (domain == null) return null;
        return UsuarioJpaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .fotoUrl(domain.getFotoUrl())
                .rol(domain.getRol())
                .peso(domain.getPeso())
                .altura(domain.getAltura())
                .edad(domain.getEdad())
                .sexo(domain.getSexo())
                .actividadDiaria(domain.getActividadDiaria())
                .objetivo(domain.getObjetivo())
                .caloriasObjetivo(domain.getCaloriasObjetivo())
                .fechaRegistro(domain.getFechaRegistro())
                .build();
    }
}

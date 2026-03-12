package com.gymapp.modules.usuario.infrastructure.mapper;

import com.gymapp.modules.usuario.application.dto.UsuarioRequest;
import com.gymapp.modules.usuario.application.dto.UsuarioResponse;
import com.gymapp.modules.usuario.domain.model.Usuario;
import com.gymapp.modules.usuario.infrastructure.output.jpa.UsuarioJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    // Request -> Domain
    public Usuario toDomain(UsuarioRequest request) {
        if (request == null) return null;

        return Usuario.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .fotoUrl(request.getFotoUrl())
                .rol(request.getRol())
                .peso(request.getPeso())
                .altura(request.getAltura())
                .edad(request.getEdad())
                .sexo(request.getSexo())
                .actividadDiaria(request.getActividadDiaria())
                .objetivo(request.getObjetivo())
                .caloriasObjetivo(request.getCaloriasObjetivo())
                .build();
    }

    // Domain -> Response
    public UsuarioResponse toResponse(Usuario domain) {
        if (domain == null) return null;

        return UsuarioResponse.builder()
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

    // JPA -> Domain
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

    // Domain -> JPA
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
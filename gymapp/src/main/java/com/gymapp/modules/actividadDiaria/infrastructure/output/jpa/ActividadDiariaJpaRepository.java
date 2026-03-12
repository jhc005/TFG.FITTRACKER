package com.gymapp.modules.actividadDiaria.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadDiariaJpaRepository extends JpaRepository<ActividadDiariaJpaEntity, Integer> {
    List<ActividadDiariaJpaEntity> findByUsuarioId(String usuarioId);
}

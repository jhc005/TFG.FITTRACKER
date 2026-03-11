package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.infrastructure.adapter.out.persistence.entity.ActividadDiariaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadDiariaJpaRepository extends JpaRepository<ActividadDiariaJpaEntity, Integer> {
    List<ActividadDiariaJpaEntity> findByUsuarioId(String usuarioId);
}

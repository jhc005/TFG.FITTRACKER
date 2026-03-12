package com.gymapp.modules.receta.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymapp.modules.enums.ObjetivoReceta;

import java.util.List;

public interface RecetaJpaRepository extends JpaRepository<RecetaJpaEntity, Integer> {
    List<RecetaJpaEntity> findByObjetivoApto(ObjetivoReceta objetivo);
}

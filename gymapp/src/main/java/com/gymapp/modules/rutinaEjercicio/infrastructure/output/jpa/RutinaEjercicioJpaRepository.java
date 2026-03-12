package com.gymapp.modules.rutinaEjercicio.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaEjercicioJpaRepository extends JpaRepository<RutinaEjercicioJpaEntity, Integer> {
    List<RutinaEjercicioJpaEntity> findByRutinaId(Integer rutinaId);
}

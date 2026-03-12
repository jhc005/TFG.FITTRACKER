package com.gymapp.modules.rutina.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaJpaRepository extends JpaRepository<RutinaJpaEntity, Integer> {
    List<RutinaJpaEntity> findByCreadoPor(String creadoPor);
}

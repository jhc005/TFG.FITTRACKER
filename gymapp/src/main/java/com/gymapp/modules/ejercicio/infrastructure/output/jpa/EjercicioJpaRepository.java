package com.gymapp.modules.ejercicio.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioJpaRepository extends JpaRepository<EjercicioJpaEntity, Integer> {
}

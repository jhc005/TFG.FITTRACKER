package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.infrastructure.adapter.out.persistence.entity.EjercicioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioJpaRepository extends JpaRepository<EjercicioJpaEntity, Integer> {
}

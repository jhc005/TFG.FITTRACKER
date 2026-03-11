package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.infrastructure.adapter.out.persistence.entity.RutinaEjercicioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaEjercicioJpaRepository extends JpaRepository<RutinaEjercicioJpaEntity, Integer> {
    List<RutinaEjercicioJpaEntity> findByRutinaId(Integer rutinaId);
}

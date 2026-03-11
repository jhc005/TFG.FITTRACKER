package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.domain.model.enums.ObjetivoReceta;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RecetaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaJpaRepository extends JpaRepository<RecetaJpaEntity, Integer> {
    List<RecetaJpaEntity> findByObjetivoApto(ObjetivoReceta objetivo);
}

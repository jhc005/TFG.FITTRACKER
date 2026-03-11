package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.infrastructure.adapter.out.persistence.entity.MiDietaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MiDietaJpaRepository extends JpaRepository<MiDietaJpaEntity, Integer> {
    List<MiDietaJpaEntity> findByUsuarioId(String usuarioId);
}

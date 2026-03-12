package com.gymapp.modules.miDieta.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MiDietaJpaRepository extends JpaRepository<MiDietaJpaEntity, Integer> {
    List<MiDietaJpaEntity> findByUsuarioId(String usuarioId);
}

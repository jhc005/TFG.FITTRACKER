package com.gymapp.infrastructure.adapter.out.persistence.repository;

import com.gymapp.infrastructure.adapter.out.persistence.entity.RegistroEntrenamientoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroEntrenamientoJpaRepository extends JpaRepository<RegistroEntrenamientoJpaEntity, Integer> {
    List<RegistroEntrenamientoJpaEntity> findByUsuarioId(String usuarioId);
    List<RegistroEntrenamientoJpaEntity> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId);
}

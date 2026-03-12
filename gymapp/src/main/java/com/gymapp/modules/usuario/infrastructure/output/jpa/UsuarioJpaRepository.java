package com.gymapp.modules.usuario.infrastructure.output.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpaEntity, String> {
}

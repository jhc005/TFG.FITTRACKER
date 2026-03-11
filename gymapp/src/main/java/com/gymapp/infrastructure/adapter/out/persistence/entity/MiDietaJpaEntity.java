package com.gymapp.infrastructure.adapter.out.persistence.entity;

import com.gymapp.domain.model.enums.DiaSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mi_dieta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiDietaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "receta_id")
    private Integer recetaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DiaSemana diaSemana;
}

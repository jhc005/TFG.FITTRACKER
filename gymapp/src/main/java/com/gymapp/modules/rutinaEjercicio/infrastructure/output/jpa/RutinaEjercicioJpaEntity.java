package com.gymapp.modules.rutinaEjercicio.infrastructure.output.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutina_ejercicios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rutina_id")
    private Integer rutinaId;

    @Column(name = "ejercicio_id")
    private Integer ejercicioId;

    @Column(name = "series")
    private Integer series;

    @Column(name = "repeticiones")
    private Integer repeticiones;
}

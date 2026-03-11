package com.gymapp.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutinas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "es_personalizada")
    private Boolean esPersonalizada;

    @Column(name = "creado_por")
    private String creadoPor;
}

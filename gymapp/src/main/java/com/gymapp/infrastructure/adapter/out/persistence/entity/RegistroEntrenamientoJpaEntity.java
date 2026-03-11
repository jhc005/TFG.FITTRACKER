package com.gymapp.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "registros_entrenamiento")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEntrenamientoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "ejercicio_id")
    private Integer ejercicioId;

    @Column(name = "peso_levantado")
    private Float pesoLevantado;

    @CreationTimestamp
    @Column(name = "fecha", insertable = false, updatable = false)
    private LocalDateTime fecha;
}

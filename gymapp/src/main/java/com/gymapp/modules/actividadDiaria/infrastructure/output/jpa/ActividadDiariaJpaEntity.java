package com.gymapp.modules.actividadDiaria.infrastructure.output.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "actividad_diaria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActividadDiariaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "pasos")
    private Integer pasos;

    @Column(name = "km_recorridos")
    private Float kmRecorridos;

    @Column(name = "calorias_gastadas")
    private Integer caloriasGastadas;

    @CreationTimestamp
    @Column(name = "fecha", insertable = false, updatable = false)
    private LocalDateTime fecha;
}

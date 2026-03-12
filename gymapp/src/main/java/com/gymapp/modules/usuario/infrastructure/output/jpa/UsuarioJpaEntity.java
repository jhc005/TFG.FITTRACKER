package com.gymapp.modules.usuario.infrastructure.output.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import com.gymapp.modules.enums.NivelActividad;
import com.gymapp.modules.enums.ObjetivoUsuario;
import com.gymapp.modules.enums.RolUsuario;
import com.gymapp.modules.enums.SexoUsuario;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RolUsuario rol;

    @Column(name = "peso")
    private Float peso;

    @Column(name = "altura")
    private Float altura;

    @Column(name = "edad")
    private Integer edad;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private SexoUsuario sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "actividad_diaria")
    private NivelActividad actividadDiaria;

    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo")
    private ObjetivoUsuario objetivo;

    @Column(name = "calorias_objetivo")
    private Integer caloriasObjetivo;

    @CreationTimestamp
    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;
}

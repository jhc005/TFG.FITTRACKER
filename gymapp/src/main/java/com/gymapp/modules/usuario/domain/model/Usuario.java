package com.gymapp.modules.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.gymapp.modules.enums.NivelActividad;
import com.gymapp.modules.enums.ObjetivoUsuario;
import com.gymapp.modules.enums.RolUsuario;
import com.gymapp.modules.enums.SexoUsuario;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String id;
    private String nombre;
    private String fotoUrl;
    private RolUsuario rol;
    private Float peso;
    private Float altura;
    private Integer edad;
    private SexoUsuario sexo;
    private NivelActividad actividadDiaria;
    private ObjetivoUsuario objetivo;
    private Integer caloriasObjetivo;
    private LocalDateTime fechaRegistro;
}

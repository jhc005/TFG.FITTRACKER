package com.gymapp.infrastructure.adapter.in.web.dto;

import com.gymapp.domain.model.enums.NivelActividad;
import com.gymapp.domain.model.enums.ObjetivoUsuario;
import com.gymapp.domain.model.enums.RolUsuario;
import com.gymapp.domain.model.enums.SexoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
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

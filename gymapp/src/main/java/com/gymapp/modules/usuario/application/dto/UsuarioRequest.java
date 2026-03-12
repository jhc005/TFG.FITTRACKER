package com.gymapp.modules.usuario.application.dto;

import com.gymapp.modules.enums.NivelActividad;
import com.gymapp.modules.enums.ObjetivoUsuario;
import com.gymapp.modules.enums.RolUsuario;
import com.gymapp.modules.enums.SexoUsuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String nombre;

    private String fotoUrl;

    @NotNull
    private RolUsuario rol;

    private Float peso;
    private Float altura;
    private Integer edad;
    private SexoUsuario sexo;
    private NivelActividad actividadDiaria;
    private ObjetivoUsuario objetivo;
    private Integer caloriasObjetivo;
}

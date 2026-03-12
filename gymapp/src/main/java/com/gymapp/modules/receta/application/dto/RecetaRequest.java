package com.gymapp.modules.receta.application.dto;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.enums.TipoReceta;

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
public class RecetaRequest {

    @NotBlank
    private String nombre;

    @NotNull
    private TipoReceta tipo;

    @NotNull
    private ObjetivoReceta objetivoApto;

    private Float proteinas;
    private Float carbohidratos;
    private Float grasas;
    private Integer calorias_totales;
    private String instrucciones;
    private String fotoUrl;
}

package com.gymapp.modules.ejercicio.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioRequest {

    @NotBlank
    private String nombre;

    private String videoUrl;
    private String descripcion;
}

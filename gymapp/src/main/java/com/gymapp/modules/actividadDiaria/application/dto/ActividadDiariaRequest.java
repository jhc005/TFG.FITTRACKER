package com.gymapp.modules.actividadDiaria.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActividadDiariaRequest {

    @NotBlank
    private String usuarioId;

    private Integer pasos;
    private Float kmRecorridos;
    private Integer caloriasGastadas;
}

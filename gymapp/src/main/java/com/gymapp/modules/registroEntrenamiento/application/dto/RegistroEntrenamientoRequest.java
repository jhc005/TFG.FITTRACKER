package com.gymapp.modules.registroEntrenamiento.application.dto;

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
public class RegistroEntrenamientoRequest {

    @NotBlank
    private String usuarioId;

    @NotNull
    private Integer ejercicioId;

    private Float pesoLevantado;
}

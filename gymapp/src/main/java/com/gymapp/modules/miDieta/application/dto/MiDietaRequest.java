package com.gymapp.modules.miDieta.application.dto;

import com.gymapp.modules.enums.DiaSemana;

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
public class MiDietaRequest {

    @NotBlank
    private String usuarioId;

    @NotNull
    private Integer recetaId;

    @NotNull
    private DiaSemana diaSemana;
}

package com.gymapp.modules.miDieta.application.dto;

import com.gymapp.modules.enums.DiaSemana;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiDietaResponse {
    private Integer id;
    private String usuarioId;
    private Integer recetaId;
    private DiaSemana diaSemana;
}

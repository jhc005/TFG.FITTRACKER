package com.gymapp.infrastructure.adapter.in.web.dto;

import com.gymapp.domain.model.enums.DiaSemana;
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

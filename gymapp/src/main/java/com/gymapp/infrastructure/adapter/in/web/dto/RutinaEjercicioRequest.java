package com.gymapp.infrastructure.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicioRequest {

    @NotNull
    private Integer rutinaId;

    @NotNull
    private Integer ejercicioId;

    @NotNull
    private Integer series;

    @NotNull
    private Integer repeticiones;
}

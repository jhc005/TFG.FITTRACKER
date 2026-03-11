package com.gymapp.infrastructure.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicioResponse {
    private Integer id;
    private Integer rutinaId;
    private Integer ejercicioId;
    private Integer series;
    private Integer repeticiones;
}

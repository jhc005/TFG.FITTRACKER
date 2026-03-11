package com.gymapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaEjercicio {
    private Integer id;
    private Integer rutinaId;
    private Integer ejercicioId;
    private Integer series;
    private Integer repeticiones;
}

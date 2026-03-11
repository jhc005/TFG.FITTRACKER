package com.gymapp.infrastructure.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioResponse {
    private Integer id;
    private String nombre;
    private String videoUrl;
    private String descripcion;
}

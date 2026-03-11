package com.gymapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ejercicio {
    private Integer id;
    private String nombre;
    private String videoUrl;
    private String descripcion;
}

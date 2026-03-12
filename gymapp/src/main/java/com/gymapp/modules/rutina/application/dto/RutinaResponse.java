package com.gymapp.modules.rutina.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RutinaResponse {
    private Integer id;
    private String nombre;
    private Integer nivel;
    private Boolean esPersonalizada;
    private String creadoPor;
}

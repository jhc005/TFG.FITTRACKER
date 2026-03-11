package com.gymapp.infrastructure.adapter.in.web.dto;

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

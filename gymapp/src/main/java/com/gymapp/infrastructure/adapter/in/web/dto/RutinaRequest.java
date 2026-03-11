package com.gymapp.infrastructure.adapter.in.web.dto;

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
public class RutinaRequest {

    @NotBlank
    private String nombre;

    @NotNull
    private Integer nivel;

    @NotNull
    private Boolean esPersonalizada;

    private String creadoPor;
}

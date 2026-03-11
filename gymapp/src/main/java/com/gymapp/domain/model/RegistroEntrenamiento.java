package com.gymapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEntrenamiento {
    private Integer id;
    private String usuarioId;
    private Integer ejercicioId;
    private Float pesoLevantado;
    private LocalDateTime fecha;
}

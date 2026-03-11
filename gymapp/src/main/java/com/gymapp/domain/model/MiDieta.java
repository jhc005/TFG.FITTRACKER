package com.gymapp.domain.model;

import com.gymapp.domain.model.enums.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiDieta {
    private Integer id;
    private String usuarioId;
    private Integer recetaId;
    private DiaSemana diaSemana;
}

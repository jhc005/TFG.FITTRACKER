package com.gymapp.modules.receta.domain.model;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.enums.TipoReceta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receta {
    private Integer id;
    private String nombre;
    private TipoReceta tipo;
    private ObjetivoReceta objetivoApto;
    private Float proteinas;
    private Float carbohidratos;
    private Float grasas;
    private Integer calorias_totales;
    private String instrucciones;
    private String fotoUrl;
}

package com.gymapp.modules.receta.infrastructure.output.jpa;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.enums.TipoReceta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recetas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecetaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoReceta tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo_apto")
    private ObjetivoReceta objetivoApto;

    @Column(name = "proteinas")
    private Float proteinas;

    @Column(name = "carbohidratos")
    private Float carbohidratos;

    @Column(name = "grasas")
    private Float grasas;

    @Column(name = "calorias_totales")
    private Integer calorias_totales;

    @Column(name = "instrucciones", columnDefinition = "TEXT")
    private String instrucciones;

    @Column(name = "foto_url")
    private String fotoUrl;
}

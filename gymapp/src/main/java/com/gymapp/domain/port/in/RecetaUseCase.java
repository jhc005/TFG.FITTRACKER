package com.gymapp.domain.port.in;

import com.gymapp.domain.model.Receta;
import com.gymapp.domain.model.enums.ObjetivoReceta;

import java.util.List;
import java.util.Optional;

public interface RecetaUseCase {
    Optional<Receta> findById(Integer id);
    List<Receta> findAll();
    List<Receta> findByObjetivo(ObjetivoReceta objetivo);
    Receta save(Receta receta);
    Receta update(Integer id, Receta receta);
    void delete(Integer id);
}

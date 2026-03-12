package com.gymapp.modules.receta.domain.outport;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.receta.domain.model.Receta;

import java.util.List;
import java.util.Optional;

public interface RecetaRepositoryPort {
    Optional<Receta> findById(Integer id);
    List<Receta> findAll();
    List<Receta> findByObjetivo(ObjetivoReceta objetivo);
    Receta save(Receta receta);
    Receta update(Integer id, Receta receta);
    void delete(Integer id);
}

package com.gymapp.modules.receta.application;

import com.gymapp.modules.enums.ObjetivoReceta;
import com.gymapp.modules.receta.domain.model.Receta;
import com.gymapp.modules.receta.domain.outport.RecetaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecetaService {

    private final RecetaRepositoryPort recetaRepositoryPort;

    public Optional<Receta> findById(Integer id) {
        return recetaRepositoryPort.findById(id);
    }

    public List<Receta> findAll() {
        return recetaRepositoryPort.findAll();
    }

    public List<Receta> findByObjetivo(ObjetivoReceta objetivo) {
        return recetaRepositoryPort.findByObjetivo(objetivo);
    }

    public Receta save(Receta receta) {
        return recetaRepositoryPort.save(receta);
    }

    public Receta update(Integer id, Receta receta) {
        return recetaRepositoryPort.update(id, receta);
    }

    public void delete(Integer id) {
        recetaRepositoryPort.delete(id);
    }
}

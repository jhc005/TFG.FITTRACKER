package com.gymapp.domain.service;

import com.gymapp.domain.model.Receta;
import com.gymapp.domain.model.enums.ObjetivoReceta;
import com.gymapp.domain.port.in.RecetaUseCase;
import com.gymapp.domain.port.out.RecetaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecetaService implements RecetaUseCase {

    private final RecetaRepositoryPort recetaRepositoryPort;

    @Override
    public Optional<Receta> findById(Integer id) {
        return recetaRepositoryPort.findById(id);
    }

    @Override
    public List<Receta> findAll() {
        return recetaRepositoryPort.findAll();
    }

    @Override
    public List<Receta> findByObjetivo(ObjetivoReceta objetivo) {
        return recetaRepositoryPort.findByObjetivo(objetivo);
    }

    @Override
    public Receta save(Receta receta) {
        return recetaRepositoryPort.save(receta);
    }

    @Override
    public Receta update(Integer id, Receta receta) {
        return recetaRepositoryPort.update(id, receta);
    }

    @Override
    public void delete(Integer id) {
        recetaRepositoryPort.delete(id);
    }
}

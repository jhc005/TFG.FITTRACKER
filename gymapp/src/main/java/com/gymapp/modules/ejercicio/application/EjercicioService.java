package com.gymapp.modules.ejercicio.application;

import com.gymapp.modules.ejercicio.domain.model.Ejercicio;
import com.gymapp.modules.ejercicio.domain.outport.EjercicioRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EjercicioService {

    private final EjercicioRepositoryPort ejercicioRepositoryPort;

    public Optional<Ejercicio> findById(Integer id) {
        return ejercicioRepositoryPort.findById(id);
    }

    public List<Ejercicio> findAll() {
        return ejercicioRepositoryPort.findAll();
    }

    public Ejercicio save(Ejercicio ejercicio) {
        return ejercicioRepositoryPort.save(ejercicio);
    }

    public Ejercicio update(Integer id, Ejercicio ejercicio) {
        return ejercicioRepositoryPort.update(id, ejercicio);
    }

    public void delete(Integer id) {
        ejercicioRepositoryPort.delete(id);
    }
}

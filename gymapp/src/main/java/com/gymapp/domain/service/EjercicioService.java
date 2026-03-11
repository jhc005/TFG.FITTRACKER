package com.gymapp.domain.service;

import com.gymapp.domain.model.Ejercicio;
import com.gymapp.domain.port.in.EjercicioUseCase;
import com.gymapp.domain.port.out.EjercicioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EjercicioService implements EjercicioUseCase {

    private final EjercicioRepositoryPort ejercicioRepositoryPort;

    @Override
    public Optional<Ejercicio> findById(Integer id) {
        return ejercicioRepositoryPort.findById(id);
    }

    @Override
    public List<Ejercicio> findAll() {
        return ejercicioRepositoryPort.findAll();
    }

    @Override
    public Ejercicio save(Ejercicio ejercicio) {
        return ejercicioRepositoryPort.save(ejercicio);
    }

    @Override
    public Ejercicio update(Integer id, Ejercicio ejercicio) {
        return ejercicioRepositoryPort.update(id, ejercicio);
    }

    @Override
    public void delete(Integer id) {
        ejercicioRepositoryPort.delete(id);
    }
}

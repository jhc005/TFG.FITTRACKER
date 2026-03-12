package com.gymapp.modules.ejercicio.application;

import java.util.List;
import java.util.Optional;

import com.gymapp.modules.ejercicio.domain.model.Ejercicio;

public interface EjercicioUseCase {
    Optional<Ejercicio> findById(Integer id);
    List<Ejercicio> findAll();
    Ejercicio save(Ejercicio ejercicio);
    Ejercicio update(Integer id, Ejercicio ejercicio);
    void delete(Integer id);
}

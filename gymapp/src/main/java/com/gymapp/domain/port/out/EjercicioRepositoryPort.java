package com.gymapp.domain.port.out;

import com.gymapp.domain.model.Ejercicio;

import java.util.List;
import java.util.Optional;

public interface EjercicioRepositoryPort {
    Optional<Ejercicio> findById(Integer id);
    List<Ejercicio> findAll();
    Ejercicio save(Ejercicio ejercicio);
    Ejercicio update(Integer id, Ejercicio ejercicio);
    void delete(Integer id);
}

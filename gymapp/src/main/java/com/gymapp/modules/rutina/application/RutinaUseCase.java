package com.gymapp.modules.rutina.application;

import java.util.List;
import java.util.Optional;

import com.gymapp.modules.rutina.domain.model.Rutina;

public interface RutinaUseCase {
    Optional<Rutina> findById(Integer id);
    List<Rutina> findAll();
    List<Rutina> findByUsuarioId(String usuarioId);
    Rutina save(Rutina rutina);
    Rutina update(Integer id, Rutina rutina);
    void delete(Integer id);
}

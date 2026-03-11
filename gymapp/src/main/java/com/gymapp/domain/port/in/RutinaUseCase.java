package com.gymapp.domain.port.in;

import com.gymapp.domain.model.Rutina;

import java.util.List;
import java.util.Optional;

public interface RutinaUseCase {
    Optional<Rutina> findById(Integer id);
    List<Rutina> findAll();
    List<Rutina> findByUsuarioId(String usuarioId);
    Rutina save(Rutina rutina);
    Rutina update(Integer id, Rutina rutina);
    void delete(Integer id);
}

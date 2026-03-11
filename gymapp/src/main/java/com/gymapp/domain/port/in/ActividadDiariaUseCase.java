package com.gymapp.domain.port.in;

import com.gymapp.domain.model.ActividadDiaria;

import java.util.List;

public interface ActividadDiariaUseCase {
    List<ActividadDiaria> findByUsuarioId(String usuarioId);
    ActividadDiaria save(ActividadDiaria actividad);
    ActividadDiaria update(Integer id, ActividadDiaria actividad);
    void delete(Integer id);
}

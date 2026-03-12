package com.gymapp.modules.actividadDiaria.application;

import java.util.List;

import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;

public interface ActividadDiariaUseCase {
    List<ActividadDiaria> findByUsuarioId(String usuarioId);
    ActividadDiaria save(ActividadDiaria actividad);
    ActividadDiaria update(Integer id, ActividadDiaria actividad);
    void delete(Integer id);
}

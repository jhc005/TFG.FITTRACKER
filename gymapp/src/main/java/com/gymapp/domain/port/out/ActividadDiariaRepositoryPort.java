package com.gymapp.domain.port.out;

import com.gymapp.domain.model.ActividadDiaria;

import java.util.List;

public interface ActividadDiariaRepositoryPort {
    List<ActividadDiaria> findByUsuarioId(String usuarioId);
    ActividadDiaria save(ActividadDiaria actividad);
    ActividadDiaria update(Integer id, ActividadDiaria actividad);
    void delete(Integer id);
}

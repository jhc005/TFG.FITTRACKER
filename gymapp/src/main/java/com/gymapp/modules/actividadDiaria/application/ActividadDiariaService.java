package com.gymapp.modules.actividadDiaria.application;

import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;
import com.gymapp.modules.actividadDiaria.domain.outport.ActividadDiariaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActividadDiariaService  {

    private final ActividadDiariaRepositoryPort actividadDiariaRepositoryPort;

    public List<ActividadDiaria> findByUsuarioId(String usuarioId) {
        return actividadDiariaRepositoryPort.findByUsuarioId(usuarioId);
    }

    public ActividadDiaria save(ActividadDiaria actividad) {
        return actividadDiariaRepositoryPort.save(actividad);
    }

    public ActividadDiaria update(Integer id, ActividadDiaria actividad) {
        return actividadDiariaRepositoryPort.update(id, actividad);
    }

    public void delete(Integer id) {
        actividadDiariaRepositoryPort.delete(id);
    }
}

package com.gymapp.modules.actividadDiaria.application;

import com.gymapp.modules.actividadDiaria.domain.model.ActividadDiaria;
import com.gymapp.modules.actividadDiaria.domain.outport.ActividadDiariaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActividadDiariaService implements ActividadDiariaUseCase {

    private final ActividadDiariaRepositoryPort actividadDiariaRepositoryPort;

    @Override
    public List<ActividadDiaria> findByUsuarioId(String usuarioId) {
        return actividadDiariaRepositoryPort.findByUsuarioId(usuarioId);
    }

    @Override
    public ActividadDiaria save(ActividadDiaria actividad) {
        return actividadDiariaRepositoryPort.save(actividad);
    }

    @Override
    public ActividadDiaria update(Integer id, ActividadDiaria actividad) {
        return actividadDiariaRepositoryPort.update(id, actividad);
    }

    @Override
    public void delete(Integer id) {
        actividadDiariaRepositoryPort.delete(id);
    }
}

package com.gymapp.domain.service;

import com.gymapp.domain.model.ActividadDiaria;
import com.gymapp.domain.port.in.ActividadDiariaUseCase;
import com.gymapp.domain.port.out.ActividadDiariaRepositoryPort;
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

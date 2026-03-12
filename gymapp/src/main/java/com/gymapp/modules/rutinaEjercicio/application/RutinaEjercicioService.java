package com.gymapp.modules.rutinaEjercicio.application;

import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;
import com.gymapp.modules.rutinaEjercicio.domain.outport.RutinaEjercicioRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutinaEjercicioService  {

    private final RutinaEjercicioRepositoryPort rutinaEjercicioRepositoryPort;

    public List<RutinaEjercicio> findByRutinaId(Integer rutinaId) {
        return rutinaEjercicioRepositoryPort.findByRutinaId(rutinaId);
    }

    public RutinaEjercicio save(RutinaEjercicio re) {
        return rutinaEjercicioRepositoryPort.save(re);
    }

    public RutinaEjercicio update(Integer id, RutinaEjercicio re) {
        return rutinaEjercicioRepositoryPort.update(id, re);
    }

    public void delete(Integer id) {
        rutinaEjercicioRepositoryPort.delete(id);
    }
}

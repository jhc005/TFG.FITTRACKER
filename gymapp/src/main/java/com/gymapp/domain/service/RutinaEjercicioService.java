package com.gymapp.domain.service;

import com.gymapp.domain.model.RutinaEjercicio;
import com.gymapp.domain.port.in.RutinaEjercicioUseCase;
import com.gymapp.domain.port.out.RutinaEjercicioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RutinaEjercicioService implements RutinaEjercicioUseCase {

    private final RutinaEjercicioRepositoryPort rutinaEjercicioRepositoryPort;

    @Override
    public List<RutinaEjercicio> findByRutinaId(Integer rutinaId) {
        return rutinaEjercicioRepositoryPort.findByRutinaId(rutinaId);
    }

    @Override
    public RutinaEjercicio save(RutinaEjercicio re) {
        return rutinaEjercicioRepositoryPort.save(re);
    }

    @Override
    public RutinaEjercicio update(Integer id, RutinaEjercicio re) {
        return rutinaEjercicioRepositoryPort.update(id, re);
    }

    @Override
    public void delete(Integer id) {
        rutinaEjercicioRepositoryPort.delete(id);
    }
}

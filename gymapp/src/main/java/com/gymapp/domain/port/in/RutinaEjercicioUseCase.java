package com.gymapp.domain.port.in;

import com.gymapp.domain.model.RutinaEjercicio;

import java.util.List;

public interface RutinaEjercicioUseCase {
    List<RutinaEjercicio> findByRutinaId(Integer rutinaId);
    RutinaEjercicio save(RutinaEjercicio re);
    RutinaEjercicio update(Integer id, RutinaEjercicio re);
    void delete(Integer id);
}

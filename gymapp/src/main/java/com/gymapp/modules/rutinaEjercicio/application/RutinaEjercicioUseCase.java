package com.gymapp.modules.rutinaEjercicio.application;

import java.util.List;

import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;

public interface RutinaEjercicioUseCase {
    List<RutinaEjercicio> findByRutinaId(Integer rutinaId);
    RutinaEjercicio save(RutinaEjercicio re);
    RutinaEjercicio update(Integer id, RutinaEjercicio re);
    void delete(Integer id);
}

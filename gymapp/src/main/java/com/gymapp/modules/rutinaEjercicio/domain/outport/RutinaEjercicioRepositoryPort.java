package com.gymapp.modules.rutinaEjercicio.domain.outport;

import java.util.List;

import com.gymapp.modules.rutinaEjercicio.domain.model.RutinaEjercicio;

public interface RutinaEjercicioRepositoryPort {
    List<RutinaEjercicio> findByRutinaId(Integer rutinaId);
    RutinaEjercicio save(RutinaEjercicio re);
    RutinaEjercicio update(Integer id, RutinaEjercicio re);
    void delete(Integer id);
}

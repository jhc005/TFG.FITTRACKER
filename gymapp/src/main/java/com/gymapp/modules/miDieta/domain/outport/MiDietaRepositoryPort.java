package com.gymapp.modules.miDieta.domain.outport;

import java.util.List;

import com.gymapp.modules.miDieta.domain.model.MiDieta;

public interface MiDietaRepositoryPort {
    List<MiDieta> findByUsuarioId(String usuarioId);
    MiDieta save(MiDieta miDieta);
    void delete(Integer id);
}

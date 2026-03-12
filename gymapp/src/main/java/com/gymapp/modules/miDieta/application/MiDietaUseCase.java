package com.gymapp.modules.miDieta.application;

import java.util.List;

import com.gymapp.modules.miDieta.domain.model.MiDieta;

public interface MiDietaUseCase {
    List<MiDieta> findByUsuarioId(String usuarioId);
    MiDieta save(MiDieta miDieta);
    void delete(Integer id);
}

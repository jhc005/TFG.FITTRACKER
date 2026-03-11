package com.gymapp.domain.port.in;

import com.gymapp.domain.model.MiDieta;

import java.util.List;

public interface MiDietaUseCase {
    List<MiDieta> findByUsuarioId(String usuarioId);
    MiDieta save(MiDieta miDieta);
    void delete(Integer id);
}

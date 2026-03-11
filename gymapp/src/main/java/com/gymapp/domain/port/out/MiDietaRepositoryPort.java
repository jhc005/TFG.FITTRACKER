package com.gymapp.domain.port.out;

import com.gymapp.domain.model.MiDieta;

import java.util.List;

public interface MiDietaRepositoryPort {
    List<MiDieta> findByUsuarioId(String usuarioId);
    MiDieta save(MiDieta miDieta);
    void delete(Integer id);
}

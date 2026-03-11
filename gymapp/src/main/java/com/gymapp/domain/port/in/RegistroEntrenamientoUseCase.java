package com.gymapp.domain.port.in;

import com.gymapp.domain.model.RegistroEntrenamiento;

import java.util.List;

public interface RegistroEntrenamientoUseCase {
    List<RegistroEntrenamiento> findByUsuarioId(String usuarioId);
    List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId);
    RegistroEntrenamiento save(RegistroEntrenamiento registro);
    void delete(Integer id);
}

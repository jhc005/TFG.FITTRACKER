package com.gymapp.modules.registroEntrenamiento.application;

import java.util.List;

import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;

public interface RegistroEntrenamientoUseCase {
    List<RegistroEntrenamiento> findByUsuarioId(String usuarioId);
    List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId);
    RegistroEntrenamiento save(RegistroEntrenamiento registro);
    void delete(Integer id);
}

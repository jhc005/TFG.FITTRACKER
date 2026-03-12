package com.gymapp.modules.registroEntrenamiento.domain.output;

import java.util.List;

import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;

public interface RegistroEntrenamientoRepositoryPort {
    List<RegistroEntrenamiento> findByUsuarioId(String usuarioId);
    List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId);
    RegistroEntrenamiento save(RegistroEntrenamiento registro);
    void delete(Integer id);
}

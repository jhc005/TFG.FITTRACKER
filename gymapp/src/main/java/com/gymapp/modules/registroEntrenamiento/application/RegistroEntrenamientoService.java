package com.gymapp.modules.registroEntrenamiento.application;

import com.gymapp.modules.registroEntrenamiento.domain.model.RegistroEntrenamiento;
import com.gymapp.modules.registroEntrenamiento.domain.output.RegistroEntrenamientoRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroEntrenamientoService {

    private final RegistroEntrenamientoRepositoryPort registroEntrenamientoRepositoryPort;

    public List<RegistroEntrenamiento> findByUsuarioId(String usuarioId) {
        return registroEntrenamientoRepositoryPort.findByUsuarioId(usuarioId);
    }

    public List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId) {
        return registroEntrenamientoRepositoryPort.findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId);
    }

    public RegistroEntrenamiento save(RegistroEntrenamiento registro) {
        return registroEntrenamientoRepositoryPort.save(registro);
    }

    public void delete(Integer id) {
        registroEntrenamientoRepositoryPort.delete(id);
    }
}

package com.gymapp.domain.service;

import com.gymapp.domain.model.RegistroEntrenamiento;
import com.gymapp.domain.port.in.RegistroEntrenamientoUseCase;
import com.gymapp.domain.port.out.RegistroEntrenamientoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroEntrenamientoService implements RegistroEntrenamientoUseCase {

    private final RegistroEntrenamientoRepositoryPort registroEntrenamientoRepositoryPort;

    @Override
    public List<RegistroEntrenamiento> findByUsuarioId(String usuarioId) {
        return registroEntrenamientoRepositoryPort.findByUsuarioId(usuarioId);
    }

    @Override
    public List<RegistroEntrenamiento> findByUsuarioIdAndEjercicioId(String usuarioId, Integer ejercicioId) {
        return registroEntrenamientoRepositoryPort.findByUsuarioIdAndEjercicioId(usuarioId, ejercicioId);
    }

    @Override
    public RegistroEntrenamiento save(RegistroEntrenamiento registro) {
        return registroEntrenamientoRepositoryPort.save(registro);
    }

    @Override
    public void delete(Integer id) {
        registroEntrenamientoRepositoryPort.delete(id);
    }
}

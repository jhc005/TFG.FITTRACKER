package com.gymapp.domain.service;

import com.gymapp.domain.model.MiDieta;
import com.gymapp.domain.port.in.MiDietaUseCase;
import com.gymapp.domain.port.out.MiDietaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiDietaService implements MiDietaUseCase {

    private final MiDietaRepositoryPort miDietaRepositoryPort;

    @Override
    public List<MiDieta> findByUsuarioId(String usuarioId) {
        return miDietaRepositoryPort.findByUsuarioId(usuarioId);
    }

    @Override
    public MiDieta save(MiDieta miDieta) {
        return miDietaRepositoryPort.save(miDieta);
    }

    @Override
    public void delete(Integer id) {
        miDietaRepositoryPort.delete(id);
    }
}

package com.gymapp.modules.miDieta.application;

import com.gymapp.modules.miDieta.domain.model.MiDieta;
import com.gymapp.modules.miDieta.domain.outport.MiDietaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiDietaService {

    private final MiDietaRepositoryPort miDietaRepositoryPort;

    public List<MiDieta> findByUsuarioId(String usuarioId) {
        return miDietaRepositoryPort.findByUsuarioId(usuarioId);
    }

    public MiDieta save(MiDieta miDieta) {
        return miDietaRepositoryPort.save(miDieta);
    }

    public void delete(Integer id) {
        miDietaRepositoryPort.delete(id);
    }
}

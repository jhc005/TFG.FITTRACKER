package com.gymapp.modules.rutina.application;

import com.gymapp.modules.rutina.domain.model.Rutina;
import com.gymapp.modules.rutina.domain.output.RutinaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RutinaService {

    private final RutinaRepositoryPort rutinaRepositoryPort;

    public Optional<Rutina> findById(Integer id) {
        return rutinaRepositoryPort.findById(id);
    }

    public List<Rutina> findAll() {
        return rutinaRepositoryPort.findAll();
    }

    public List<Rutina> findByUsuarioId(String usuarioId) {
        return rutinaRepositoryPort.findByUsuarioId(usuarioId);
    }

    public Rutina save(Rutina rutina) {
        return rutinaRepositoryPort.save(rutina);
    }

    public Rutina update(Integer id, Rutina rutina) {
        return rutinaRepositoryPort.update(id, rutina);
    }

    public void delete(Integer id) {
        rutinaRepositoryPort.delete(id);
    }
}

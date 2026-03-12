package com.gymapp.modules.rutina.application;

import com.gymapp.modules.rutina.domain.model.Rutina;
import com.gymapp.modules.rutina.domain.output.RutinaRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RutinaService implements RutinaUseCase {

    private final RutinaRepositoryPort rutinaRepositoryPort;

    @Override
    public Optional<Rutina> findById(Integer id) {
        return rutinaRepositoryPort.findById(id);
    }

    @Override
    public List<Rutina> findAll() {
        return rutinaRepositoryPort.findAll();
    }

    @Override
    public List<Rutina> findByUsuarioId(String usuarioId) {
        return rutinaRepositoryPort.findByUsuarioId(usuarioId);
    }

    @Override
    public Rutina save(Rutina rutina) {
        return rutinaRepositoryPort.save(rutina);
    }

    @Override
    public Rutina update(Integer id, Rutina rutina) {
        return rutinaRepositoryPort.update(id, rutina);
    }

    @Override
    public void delete(Integer id) {
        rutinaRepositoryPort.delete(id);
    }
}

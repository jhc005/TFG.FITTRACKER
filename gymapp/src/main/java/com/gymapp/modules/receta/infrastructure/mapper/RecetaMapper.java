package com.gymapp.modules.receta.infrastructure.mapper;

import com.gymapp.modules.receta.application.dto.RecetaRequest;
import com.gymapp.modules.receta.application.dto.RecetaResponse;
import com.gymapp.modules.receta.domain.model.Receta;
import com.gymapp.modules.receta.infrastructure.output.jpa.RecetaJpaEntity;

import org.springframework.stereotype.Component;

@Component
public class RecetaMapper {

    // Request -> Domain
    public Receta toDomain(RecetaRequest request) {
        if (request == null) return null;

        return Receta.builder()
                .nombre(request.getNombre())
                .tipo(request.getTipo())
                .objetivoApto(request.getObjetivoApto())
                .proteinas(request.getProteinas())
                .carbohidratos(request.getCarbohidratos())
                .grasas(request.getGrasas())
                .calorias_totales(request.getCalorias_totales())
                .instrucciones(request.getInstrucciones())
                .fotoUrl(request.getFotoUrl())
                .build();
    }

    // Domain -> Response
    public RecetaResponse toResponse(Receta domain) {
        if (domain == null) return null;

        return RecetaResponse.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .tipo(domain.getTipo())
                .objetivoApto(domain.getObjetivoApto())
                .proteinas(domain.getProteinas())
                .carbohidratos(domain.getCarbohidratos())
                .grasas(domain.getGrasas())
                .calorias_totales(domain.getCalorias_totales())
                .instrucciones(domain.getInstrucciones())
                .fotoUrl(domain.getFotoUrl())
                .build();
    }

    // JPA -> Domain
    public Receta toDomain(RecetaJpaEntity entity) {
        if (entity == null) return null;

        return Receta.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .tipo(entity.getTipo())
                .objetivoApto(entity.getObjetivoApto())
                .proteinas(entity.getProteinas())
                .carbohidratos(entity.getCarbohidratos())
                .grasas(entity.getGrasas())
                .calorias_totales(entity.getCalorias_totales())
                .instrucciones(entity.getInstrucciones())
                .fotoUrl(entity.getFotoUrl())
                .build();
    }

    // Domain -> JPA
    public RecetaJpaEntity toJpaEntity(Receta domain) {
        if (domain == null) return null;

        return RecetaJpaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .tipo(domain.getTipo())
                .objetivoApto(domain.getObjetivoApto())
                .proteinas(domain.getProteinas())
                .carbohidratos(domain.getCarbohidratos())
                .grasas(domain.getGrasas())
                .calorias_totales(domain.getCalorias_totales())
                .instrucciones(domain.getInstrucciones())
                .fotoUrl(domain.getFotoUrl())
                .build();
    }
}
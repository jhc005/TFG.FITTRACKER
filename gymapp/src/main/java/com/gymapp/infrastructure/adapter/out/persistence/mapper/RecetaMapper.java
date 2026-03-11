package com.gymapp.infrastructure.adapter.out.persistence.mapper;

import com.gymapp.domain.model.Receta;
import com.gymapp.infrastructure.adapter.out.persistence.entity.RecetaJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class RecetaMapper {

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

package com.academika.academika.mapper;

import com.academika.academika.dto.categoria.CategoriaResponseDTO;
import com.academika.academika.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaResponseDTO toDTO(Categoria categoria) {
        return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descrip(categoria.getDescrip())
                .build();
    }
}

package com.academika.academika.mapper;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.dto.categoria.CategoriaResponseDTO;
import com.academika.academika.entity.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaCursosDTO toCategoriaCursosDTO(Categoria categoria);

    Categoria toEntity(CategoriaCursosDTO categoriaCursosDTO);

    CategoriaResponseDTO toDTO(Categoria categoria);
}

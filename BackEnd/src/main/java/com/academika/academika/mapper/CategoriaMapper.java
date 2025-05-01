package com.academika.academika.mapper;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.entity.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaCursosDTO toCategoriaCursosDTO(Categoria categoria);


}

package com.academika.academika.mapper;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.dto.curso.CursoResumenDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(target = "id", ignore = true)
    Curso toEntity(CursoRequestDTO requestDTO, @Context Categoria categoria, @Context User instructor);

    @Mapping(source = "instructor.id", target = "instructor")
    @Mapping(source = "instructor.nombre", target = "nombreInstructor")
    @Mapping(source = "categoria.id", target = "idCate")
    @Mapping(source = "categoria.nombre", target = "nombreCate")
    @Mapping(source = "categoria.descrip", target = "descripCate")
    CursoResponseDTO toDTO(Curso curso);

    CursoResumenDTO toResumenDTO(Curso curso);

    List<CursoResumenDTO> toResumenDTOList(List<Curso> cursos);

    @AfterMapping
    default void afterMapToEntity(@MappingTarget Curso entity, Categoria categoria, User instructor) {
        entity.setInstructor(instructor);
        entity.setCategoria(categoria);
    }
}

package com.academika.academika.mapper;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.dto.curso.CursoResumenDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Usuario;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(source = "requestDTO.id", target = "id")
    @Mapping(source = "requestDTO.fecha", target = "fecha")
    Curso toEntity(CursoRequestDTO requestDTO, @Context Categoria categoria, @Context Usuario instructor);

    @Mapping(source = "instructor.id", target = "idInstructor")
    @Mapping(source = "instructor.nombre", target = "nombreInstructor")
    @Mapping(source = "categoria.id", target = "idCate")
    @Mapping(source = "categoria.nombre", target = "nombreCate")
    @Mapping(source = "categoria.descrip", target = "descripCate")
    CursoResponseDTO toDTO(Curso curso);

    CursoResumenDTO toResumenDTO(Curso curso);

    List<CursoResumenDTO> toResumenDTOList(List<Curso> cursos);

    @AfterMapping
    default void afterMapToEntity(@MappingTarget Curso entity, @Context Categoria categoria, @Context Usuario instructor) {
        entity.setInstructor(instructor);
        entity.setCategoria(categoria);
    }
}

package com.academika.academika.mapper;

import com.academika.academika.dto.matricula.MatriculaCursoDTO;
import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Matricula;
import com.academika.academika.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    public MatriculaResponseDTO toDTO(Matricula matricula){
        return MatriculaResponseDTO.builder()
                .id(matricula.getId())
                .fecha(matricula.getFecha())
                .idCurso(matricula.getCurso().getId())
                .idEstudiante(matricula.getEstudiante().getId())
                .nombreEstudiante(matricula.getEstudiante().getNombre())
                .nombreCurso(matricula.getCurso().getTitulo())
                .build();
    }

    public Matricula toEntity(MatriculaRequestDTO request, Usuario estudiante, Curso curso){
        return Matricula.builder()
                .estudiante(estudiante)
                .curso(curso)
                .build();
    }

    public MatriculaCursoDTO toMatriculaCursoDTO(Matricula matricula){
        return MatriculaCursoDTO.builder()
                .id(matricula.getCurso().getId())
                .nombreCurso(matricula.getCurso().getTitulo())
                .idEstudiante(matricula.getEstudiante().getId())
                .nombreEstudiante(matricula.getEstudiante().getNombre())
                .idInstructor(matricula.getCurso().getInstructor().getId())
                .nombreInstructor(matricula.getCurso().getInstructor().getNombre())
                .fecha(matricula.getFecha())
                .build();
    }
}

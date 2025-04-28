package com.academika.academika.mapper;

import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.entity.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    public MatriculaResponseDTO toDTO(Matricula matricula){
        return MatriculaResponseDTO.builder()
                .id(matricula.getId())
                .fecha(matricula.getFecha())
                .estudiante(matricula.getEstudiante())
                .curso(matricula.getCurso())
                .build();
    }

    public Matricula toEntity(MatriculaRequestDTO request){
        return Matricula.builder()
                .fecha(request.getFecha())
                .estudiante(request.getEstudiante())
                .curso(request.getCurso())
                .build();
    }





}

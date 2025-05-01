package com.academika.academika.dto.matricula;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class MatriculaCursoDTO {

    private Long id;
    private LocalDate fecha;
    private Long idEstudiante;
    private String nombreEstudiante;
    private Long idCurso;
    private String nombreCurso;
    private Long idInstructor;
    private String nombreInstructor;
}

package com.academika.academika.dto.matricula;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaRequestDTO {
    private Long idEstudiante;
    private Long idCurso;
}

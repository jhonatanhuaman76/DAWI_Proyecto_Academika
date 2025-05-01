package com.academika.academika.dto.matricula;

import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaRequestDTO {
    private Long idEstudiante;
    private Long idCurso;
}

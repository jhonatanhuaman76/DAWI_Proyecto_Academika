package com.academika.academika.dto.matricula;

import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MatriculaRequestDTO {

    private LocalDate fecha;
    //----
    private Usuario estudiante;
    private Usuario nombre;
    //---
    private Curso curso;

}

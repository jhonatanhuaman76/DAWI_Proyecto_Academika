package com.academika.academika.dto.matricula;

import com.academika.academika.entity.Curso;
import com.academika.academika.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MatriculaRequestDTO {

    private LocalDate fecha;
    //----
    private User estudiante;
    private User nombre;
    private Curso curso;

}

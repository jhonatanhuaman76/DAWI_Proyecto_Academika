package com.academika.academika.dto.matricula;


import com.academika.academika.entity.Curso;
import com.academika.academika.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MatriculaResponseDTO {

    private Long id;
    private LocalDate fecha;
    //--- De User
    private User estudiante;
    private User nombre;
    //--- De Curso
    private Curso curso;
    private Curso titulo;
    private Curso precio;


}

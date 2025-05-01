package com.academika.academika.dto.curso;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CursoRequestDTO {
    private Long id;
    private String titulo;
    private String descrip;
    private Double precio;
    private String miniatura;
    private LocalDate fecha;
    private Long idCate;
    private Long idInstructor;
}

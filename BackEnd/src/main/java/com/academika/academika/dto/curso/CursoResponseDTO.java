package com.academika.academika.dto.curso;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class    CursoResponseDTO {
    private Long id;
    private String titulo;
    private String descrip;
    private Double precio;
    private LocalDate fecha;
    private String miniatura;
    private Long idCate;
    private String nombreCate;
    private String descripCate;
    private Long idInstructor;
    private String nombreInstructor;
}

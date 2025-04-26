package com.academika.academika.dto.curso;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CursoResumenDTO {
    private Long id;
    private String titulo;
    private String descrip;
    private Double precio;
    private LocalDate fecha;
    private String miniatura;
}

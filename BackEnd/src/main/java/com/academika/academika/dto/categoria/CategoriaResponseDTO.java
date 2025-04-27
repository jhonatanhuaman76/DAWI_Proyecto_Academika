package com.academika.academika.dto.categoria;

import com.academika.academika.dto.curso.CursoResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoriaResponseDTO {
    private Long id;
    private String nombre;
    private String descrip;
}

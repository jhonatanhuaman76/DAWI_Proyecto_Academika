package com.academika.academika.dto.categoria;

import com.academika.academika.dto.curso.CursoResumenDTO;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CategoriaCursosDTO {
    private Long id;
    private String nombre;
    private String descrip;
    private List<CursoResumenDTO> cursos;
}

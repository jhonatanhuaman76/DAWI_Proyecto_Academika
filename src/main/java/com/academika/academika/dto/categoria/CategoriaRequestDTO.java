package com.academika.academika.dto.categoria;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriaRequestDTO {

    private String nombre;
    private String descrip;
}

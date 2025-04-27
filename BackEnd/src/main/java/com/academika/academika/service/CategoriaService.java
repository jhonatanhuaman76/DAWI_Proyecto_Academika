package com.academika.academika.service;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.dto.categoria.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaCursosDTO> listarConCursos();
}

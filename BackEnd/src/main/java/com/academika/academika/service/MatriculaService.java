package com.academika.academika.service;

import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;

import java.util.List;

public interface MatriculaService {

    List<MatriculaResponseDTO>listar();
    MatriculaResponseDTO registrar(MatriculaRequestDTO request);

}

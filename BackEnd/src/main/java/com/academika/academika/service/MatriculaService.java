package com.academika.academika.service;

import com.academika.academika.dto.matricula.MatriculaCursoDTO;
import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.infra.exception.CustomException;

import java.util.List;

public interface MatriculaService {

    List<MatriculaResponseDTO>listar();
    MatriculaResponseDTO registrar(MatriculaRequestDTO request) throws CustomException;
    List<MatriculaCursoDTO>listarPorEstudiante(Long id);
}

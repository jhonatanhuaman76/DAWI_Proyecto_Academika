package com.academika.academika.service;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;

import java.util.List;

public interface CursoService {

    List<CursoResponseDTO> listar();
    List<CursoResponseDTO> listarMasRecientes();
    CursoResponseDTO registrar(CursoRequestDTO requestDTO);
    CursoResponseDTO buscar(Long id);
}

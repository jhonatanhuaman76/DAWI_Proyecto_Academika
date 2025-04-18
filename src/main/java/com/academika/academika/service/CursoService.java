package com.academika.academika.service;

import com.academika.academika.dto.CursoRequestDTO;
import com.academika.academika.dto.CursoResponseDTO;

import java.util.List;

public interface CursoService {

    List<CursoResponseDTO> listarPorCategoria(Long id);
    List<CursoResponseDTO> listarMasRecientes();
    CursoResponseDTO registrar(CursoRequestDTO requestDTO);
}

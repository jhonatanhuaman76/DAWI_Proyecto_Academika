package com.academika.academika.imp;

import com.academika.academika.dto.CursoRequestDTO;
import com.academika.academika.dto.CursoResponseDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.mapper.CursoMapper;
import com.academika.academika.repository.Cursorepository;
import com.academika.academika.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {
    private final Cursorepository repository;
    private final CursoMapper mapper;

    public List<CursoResponseDTO> listarPorCategoria(Long cateId) {
        return repository.findByCategoriaId(cateId).stream().map(mapper::toDTO).toList();
    }

    public List<CursoResponseDTO> listarMasRecientes() {
        return repository.findTop5ByOrderByFechaDesc().stream().map(mapper::toDTO).toList();
    }

    public CursoResponseDTO registrar(CursoRequestDTO requestDTO) {
        requestDTO.setFecha(LocalDate.now());
        return mapper.toDTO(repository.save(mapper.toEntity(requestDTO)));
    }
}

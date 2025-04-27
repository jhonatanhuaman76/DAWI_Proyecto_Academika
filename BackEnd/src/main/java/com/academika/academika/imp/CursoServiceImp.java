package com.academika.academika.imp;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.mapper.CursoMapper;
import com.academika.academika.repository.CursoRepository;
import com.academika.academika.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {
    private final CursoRepository repository;
    private final CursoMapper mapper;

    public List<CursoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<CursoResponseDTO> listarMasRecientes() {
        return repository.findTop5ByOrderByFechaDesc().stream().map(mapper::toDTO).toList();
    }

    public CursoResponseDTO registrar(CursoRequestDTO requestDTO) {
        requestDTO.setFecha(LocalDate.now());
        return mapper.toDTO(repository.save(mapper.toEntity(requestDTO)));
    }
}

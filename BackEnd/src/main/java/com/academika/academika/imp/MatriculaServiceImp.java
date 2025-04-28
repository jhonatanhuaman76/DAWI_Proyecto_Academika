package com.academika.academika.imp;

import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.entity.Matricula;
import com.academika.academika.mapper.MatriculaMapper;
import com.academika.academika.repository.MatriculaRepository;
import com.academika.academika.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MatriculaServiceImp implements MatriculaService {
    /// Traemos las instancias
     private final MatriculaRepository repository;
     private final MatriculaMapper mapper;

    @Override
    public List<MatriculaResponseDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public MatriculaResponseDTO registrar(MatriculaRequestDTO request) {
         Matricula matricual = mapper.toEntity(request);
         Matricula guardarMatricula = repository.save(matricual);
        return mapper.toDTO(guardarMatricula);
    }
}

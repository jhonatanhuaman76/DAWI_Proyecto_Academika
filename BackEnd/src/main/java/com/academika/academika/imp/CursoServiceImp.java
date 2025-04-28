package com.academika.academika.imp;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.User;
import com.academika.academika.mapper.CursoMapper;
import com.academika.academika.repository.CategoriaRepository;
import com.academika.academika.repository.CursoRepository;
import com.academika.academika.repository.UserRepository;
import com.academika.academika.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImp implements CursoService {
    private final CursoRepository repository;
    private final UserRepository userRepository;
    private final CategoriaRepository categoriaRepository;
    private final CursoMapper mapper;

    public List<CursoResponseDTO> listar()
    {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public List<CursoResponseDTO> listarMasRecientes() {
        return repository.findTop10ByOrderByFechaDesc().stream().map(mapper::toDTO).toList();
    }

    public CursoResponseDTO registrar(CursoRequestDTO requestDTO) {
        requestDTO.setFecha(LocalDate.now());
        Categoria categoria = categoriaRepository.findById(requestDTO.getIdCategoria()).orElse(null);
        User instructor = userRepository.findById((requestDTO.getIdInstructor())).orElse(null);

        Curso curso = mapper.toEntity(requestDTO, categoria,instructor);
        return mapper.toDTO(repository.save(curso));
    }
}

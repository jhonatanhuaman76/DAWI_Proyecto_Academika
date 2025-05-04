package com.academika.academika.imp;

import com.academika.academika.dto.matricula.MatriculaCursoDTO;
import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Matricula;
import com.academika.academika.entity.TipoRolUser;
import com.academika.academika.entity.Usuario;
import com.academika.academika.infra.exception.CustomException;
import com.academika.academika.mapper.MatriculaMapper;
import com.academika.academika.repository.CursoRepository;
import com.academika.academika.repository.MatriculaRepository;
import com.academika.academika.repository.UserRepository;
import com.academika.academika.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MatriculaServiceImp implements MatriculaService {
    /// Traemos las instancias
     private final MatriculaRepository matriculaRepository;
     private final CursoRepository cursoRepository;
     private final UserRepository userRepository;
     private final MatriculaMapper mapper;

    @Override
    public List<MatriculaResponseDTO> listar() {
        return matriculaRepository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public MatriculaResponseDTO registrar(MatriculaRequestDTO request) {
        Curso curso = cursoRepository.findById(request.getIdCurso()).orElse(null);
        Usuario estudiante = userRepository.findById(request.getIdEstudiante()).orElse(null);

        assert estudiante != null;
        if(!(estudiante.getRol().equals(TipoRolUser.ESTUDIANTE) || estudiante.getRol().equals(TipoRolUser.ADMIN))) {
            throw new CustomException("El usuario no es estudiante o administrador");
        }

        if(matriculaRepository.existsByEstudianteAndCurso(estudiante, curso)) {
            throw new CustomException("Ya se encuentra matriculado");
        }

        Matricula matricula = mapper.toEntity(request, estudiante, curso);
        matricula.setFecha(LocalDate.now());
        Matricula guardarMatricula = matriculaRepository.save(matricula);
        return mapper.toDTO(guardarMatricula);
    }

    @Override
    public List<MatriculaCursoDTO> listarPorEstudiante(Long id) {
        return matriculaRepository.findByEstudianteId(id).stream()
                .map(mapper::toMatriculaCursoDTO)
                .toList();
    }
}

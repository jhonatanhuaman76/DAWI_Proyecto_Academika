package com.academika.academika.imp;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.TipoRolUser;
import com.academika.academika.entity.Usuario;
import com.academika.academika.infra.exception.CustomException;
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

    @Override
    public List<CursoResponseDTO> listar()
    {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public List<CursoResponseDTO> listarMasRecientes() {
        return repository.findTop10ByOrderByFechaDesc().stream().map(mapper::toDTO).toList();
    }

    @Override
    public CursoResponseDTO guardar(CursoRequestDTO requestDTO) {
        Usuario instructor = userRepository.findById((requestDTO.getIdInstructor())).orElseThrow(
                () -> new CustomException("No existe el instructor")
        );

        if(!(instructor.getRol().equals(TipoRolUser.INSTRUCTOR) || instructor.getRol().equals(TipoRolUser.ADMIN))) {
            throw new CustomException("El usuario no es instructor o administrador");
        }

        Categoria categoria = categoriaRepository.findById(requestDTO.getIdCate()).orElseThrow(
                () -> new CustomException("No existe la categoria")
        );
        Curso curso = mapper.toEntity(requestDTO, categoria, instructor);
        System.out.println(curso.getFecha());
        if(requestDTO.getId() == null) curso.setFecha(LocalDate.now());
        return mapper.toDTO(repository.save(curso));
    }

    @Override
    public CursoResponseDTO buscar(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public List<CursoResponseDTO> listarPorInstructor(Long id) {
        return repository.findByInstructorIdOrderByFechaDesc(id).stream().map(mapper::toDTO).toList();
    }

    @Override
    public void borrar(Long id) {
        repository.deleteById(id);
    }

}

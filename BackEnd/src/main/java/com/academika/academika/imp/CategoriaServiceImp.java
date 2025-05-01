package com.academika.academika.imp;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.dto.categoria.CategoriaResponseDTO;
import com.academika.academika.dto.curso.CursoResumenDTO;
import com.academika.academika.entity.Curso;
import com.academika.academika.mapper.CategoriaMapper;
import com.academika.academika.mapper.CursoMapper;
import com.academika.academika.repository.CategoriaRepository;
import com.academika.academika.repository.CursoRepository;
import com.academika.academika.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    @Override
    public List<CategoriaCursosDTO> listarConCursos() {
        return categoriaRepository.findAll().stream().map(categoria -> {
            CategoriaCursosDTO categoriaCursosDTO = categoriaMapper.toCategoriaCursosDTO(categoria);
            List<Curso> cursos = cursoRepository.findTop10ByCategoriaIdOrderByFechaDesc(categoria.getId());
            List<CursoResumenDTO> cursosDTO = cursoMapper.toResumenDTOList(cursos);
            categoriaCursosDTO.setList_cursos(cursosDTO);
            return categoriaCursosDTO;
        }).toList();
    }

    @Override
    public List<CategoriaResponseDTO> listar() {
        return categoriaRepository.findAll().stream().map(categoriaMapper::toDTO).toList();
    }
}

package com.academika.academika.imp;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.dto.categoria.CategoriaResponseDTO;
import com.academika.academika.mapper.CategoriaMapper;
import com.academika.academika.repository.CategoriaRepository;
import com.academika.academika.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    @Override
    public List<CategoriaCursosDTO> listarConCursos() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}

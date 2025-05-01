package com.academika.academika.controller;

import com.academika.academika.dto.categoria.CategoriaCursosDTO;
import com.academika.academika.dto.categoria.CategoriaResponseDTO;
import com.academika.academika.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService imp;

    @GetMapping("/listar-con-cursos")
    public List<CategoriaCursosDTO> listarConCursos() {
        return imp.listarConCursos();
    }

    @GetMapping("/listar")
    public List<CategoriaResponseDTO> listar() {
        return imp.listar();
    }
}

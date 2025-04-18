package com.academika.academika.controller;

import com.academika.academika.dto.CursoRequestDTO;
import com.academika.academika.dto.CursoResponseDTO;
import com.academika.academika.imp.CursoServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {
    private final CursoServiceImp imp;

    @GetMapping("/listar/categoria/{cateId}")
    public List<CursoResponseDTO> listarPorCategoria(@PathVariable Long cateId) {
        return imp.listarPorCategoria(cateId);
    }

    @GetMapping("/listar/masrecientes")
    public List<CursoResponseDTO> listarMasRecientes() {
        return imp.listarMasRecientes();
    }

    @PostMapping("/registrar")
    public CursoResponseDTO registrar(@RequestBody CursoRequestDTO requestDTO) {
        return imp.registrar(requestDTO);
    }
}

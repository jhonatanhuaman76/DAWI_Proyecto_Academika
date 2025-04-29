package com.academika.academika.controller;

import com.academika.academika.dto.curso.CursoRequestDTO;
import com.academika.academika.dto.curso.CursoResponseDTO;
import com.academika.academika.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/curso")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {
    private final CursoService imp;

    @GetMapping("/listar")
    public List<CursoResponseDTO> listar() {
        return imp.listar();
    }

    @GetMapping("/listar/masrecientes")
    public List<CursoResponseDTO> listarMasRecientes() {
        return imp.listarMasRecientes();
    }

    @PostMapping("/registrar")
    public CursoResponseDTO registrar(@RequestBody CursoRequestDTO requestDTO) {
        return imp.registrar(requestDTO);
    }

    @GetMapping("/buscar/{id}")
    public CursoResponseDTO buscar(@PathVariable Long id){
        return imp.buscar(id);
    }
}

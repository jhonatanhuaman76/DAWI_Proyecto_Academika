package com.academika.academika.controller;

import com.academika.academika.dto.matricula.MatriculaCursoDTO;
import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService service;

    @GetMapping
    public List<MatriculaResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> guardar(@RequestBody MatriculaRequestDTO requestDTO) {
        return ResponseEntity.ok().body(service.registrar(requestDTO));
    }

    @GetMapping("/estudiante/{id}")
    public List<MatriculaCursoDTO> listarPorEstudiante(@PathVariable Long id) {
        return service.listarPorEstudiante(id);
    }
}

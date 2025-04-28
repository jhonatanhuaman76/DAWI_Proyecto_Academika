package com.academika.academika.controller;

import com.academika.academika.dto.matricula.MatriculaRequestDTO;
import com.academika.academika.dto.matricula.MatriculaResponseDTO;
import com.academika.academika.service.MatriculaService;
import lombok.RequiredArgsConstructor;
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
    public MatriculaResponseDTO guardar(@RequestBody MatriculaRequestDTO requestDTO){
        return service.registrar(requestDTO);
    }

}

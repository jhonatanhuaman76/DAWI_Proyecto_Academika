package com.academika.academika.controller;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImp imp;

    @GetMapping("/listar")
    public List<UserResponseDTO> listar() {
        return imp.listar();
    }

    @PostMapping("/registrar")
    public UserResponseDTO registrar(@RequestBody UserRequestDTO requestDTO) {
        return imp.registrar(requestDTO);
    }

    @GetMapping("/instructor/{id}")
    public UserResponseDTO buscarPorInstructor(@PathVariable Long id){
        return imp.buscarPorInstructor(id);
    }
}

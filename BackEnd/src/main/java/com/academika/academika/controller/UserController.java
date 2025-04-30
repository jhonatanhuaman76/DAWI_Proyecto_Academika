package com.academika.academika.controller;

import com.academika.academika.dto.user.UserRequestDTO;
import com.academika.academika.dto.user.UserResponseDTO;
import com.academika.academika.imp.UserServiceImp;
import com.academika.academika.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImp imp;
   // private final UserService service;

    //-------------------------------------------
    //LISTAR
    @GetMapping("/listar")
    public List<UserResponseDTO> listar() {
        return imp.listar();
    }
    //Testeado ✔

    //-------------------------------------------
    //REGISTRAR
    @PostMapping("/registrar")
    public UserResponseDTO registrar(@RequestBody UserRequestDTO requestDTO) {
        return imp.registrar(requestDTO);
    }
    //Testeado ✔


    //-------------------------------------------
    //OBTENER USER
    @GetMapping("/{id}")
    public UserResponseDTO obtenerUser(@PathVariable("id") Long id){
        return imp.obtenerPorId(id);
    }
    //Testeado ✔


    //-------------------------------------------
    //ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public void eliminar (@PathVariable("id") Long id){
        imp.eliminar(id);
    }
    //Testeado ✔


    //-------------------------------------------
    //ACTUALIZAR
    @PutMapping("/actualizar/{id}")
    public UserResponseDTO actualizar(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO) {
        return imp.actualizar(id, requestDTO);
        /// Valores de actualización:

        // Nombre
        // FechaNac
        // Email
        
    } //Testeado ✔

    //-------------------------------------------

} ///FIN DE [ UserController ]

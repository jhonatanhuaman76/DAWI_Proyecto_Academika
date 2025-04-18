package com.academika.academika.mapper;

import com.academika.academika.dto.CursoRequestDTO;
import com.academika.academika.dto.CursoResponseDTO;
import com.academika.academika.entity.Categoria;
import com.academika.academika.entity.Curso;
import com.academika.academika.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public CursoResponseDTO toDTO(Curso curso){
        return CursoResponseDTO.builder()
                .id(curso.getId())
                .titulo(curso.getTitulo())
                .descrip(curso.getDescrip())
                .precio(curso.getPrecio())
                .fecha(curso.getFecha())
                .miniatura(curso.getMiniatura())
                .categoria(curso.getCategoria().getId())
                .instructor(curso.getInstructor().getId())
                .build();
    }

    public Curso toEntity(CursoRequestDTO requestDTO){
        return Curso.builder()
                .titulo(requestDTO.getTitulo())
                .descrip(requestDTO.getDescrip())
                .precio(requestDTO.getPrecio())
                .fecha(requestDTO.getFecha())
                .miniatura(requestDTO.getMiniatura())
                .categoria(Categoria.builder().id(requestDTO.getCategoria()).build())
                .instructor(User.builder().id(requestDTO.getInstructor()).build())
                .build();
    }
}

package com.academika.academika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tblCategoria")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categ")
    private Long id;

    @Column(name = "nombre_categ", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descrip_categ", length = 300, nullable = false)
    private String descrip;

    @OneToMany(mappedBy = "categoria")
    private List<Curso> cursos;
}

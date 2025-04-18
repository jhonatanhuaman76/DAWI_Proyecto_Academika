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
    @Column(name = "idCateg")
    private Long id;

    @Column(name = "nombreCateg", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripCateg", length = 300, nullable = false)
    private String descrip;

    @OneToMany(mappedBy = "tblCategoria")
    private List<Curso> cursos;
}

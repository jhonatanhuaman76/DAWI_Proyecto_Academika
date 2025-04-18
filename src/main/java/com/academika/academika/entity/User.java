package com.academika.academika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tblUser")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long id;

    @Column(name = "nombreUser", length = 250, nullable = false)
    private String nombre;

    @Column(name = "fechaNacUser", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "emailUser", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "passwordUser", length = 250, nullable = false)
    private String password;

    @Column(name = "rolUser", nullable = false)
    private TipoRolUser rol;

    @OneToMany(mappedBy = "tblUser")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "tblUser")
    private List<Matricula> matriculas;
}

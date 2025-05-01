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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "nombre_user", length = 250, nullable = false)
    private String nombre;

    @Column(name = "fecha_nac_user", nullable = false)
    private LocalDate fechaNac;

    @Column(name = "email_user", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "password_user", length = 250, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_user", nullable = false)
    private TipoRolUser rol;

    @OneToMany(mappedBy = "instructor")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;
}

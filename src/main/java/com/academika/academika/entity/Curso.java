package com.academika.academika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tblCurso")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso")
    private Long id;

    @Column(name = "tituloCurso", length = 150, nullable = false)
    private String titulo;

    @Column(name = "descripCurso", length = 300, nullable = false)
    private String descrip;

    @Column(name = "precioCurso", nullable = false)
    private Double precio;

    @Column(name = "fechaCreacionCurso", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    @OneToMany(mappedBy = "curso")
    private List<Capitulo> capitulos;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;
}

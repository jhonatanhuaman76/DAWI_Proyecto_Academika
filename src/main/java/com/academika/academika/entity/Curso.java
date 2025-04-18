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
    @Column(name = "id_curso")
    private Long id;

    @Column(name = "titulo_curso", length = 150, nullable = false)
    private String titulo;

    @Column(name = "descrip_curso", length = 300, nullable = false)
    private String descrip;

    @Column(name = "precio_curso", nullable = false)
    private Double precio;

    @Column(name = "fecha_creacion_curso", nullable = false)
    private LocalDate fecha;

    @Column(name = "miniatura_curso", nullable = false)
    private String miniatura;

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

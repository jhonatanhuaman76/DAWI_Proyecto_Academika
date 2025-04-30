package com.academika.academika.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblMatricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"estudiante_id", "curso_id"})
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    @Column(name = "fecha_matricula", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

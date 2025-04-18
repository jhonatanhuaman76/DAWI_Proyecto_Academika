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
    @Column(name = "idMatricula")
    private Long id;

    @Column(name = "fechaMatricula", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

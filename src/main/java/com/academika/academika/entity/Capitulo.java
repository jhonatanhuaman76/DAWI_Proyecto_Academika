package com.academika.academika.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblCapitulo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCapitulo")
    private Long id;

    @Column(name = "tituloCapitulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "urlCapitulo", length = 300, nullable = false)
    private String url;

    @Column(name = "ordenCapitulo", nullable = false)
    private Long orden;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

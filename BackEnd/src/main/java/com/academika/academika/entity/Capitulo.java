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
    @Column(name = "id_capitulo")
    private Long id;

    @Column(name = "titulo_capitulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "url_capitulo", length = 300, nullable = false)
    private String url;

    @Column(name = "orden_capitulo", nullable = false)
    private Long orden;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}

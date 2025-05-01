package com.academika.academika.repository;

import com.academika.academika.entity.Curso;
import com.academika.academika.entity.Matricula;
import com.academika.academika.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
    boolean existsByEstudianteAndCurso(Usuario estudiante, Curso curso);

    List<Matricula> findByEstudianteId(Long id);
}

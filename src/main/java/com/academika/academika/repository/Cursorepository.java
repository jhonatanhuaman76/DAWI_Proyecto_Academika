package com.academika.academika.repository;

import com.academika.academika.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Cursorepository extends JpaRepository<Curso, Long> {

    List<Curso> findByCategoriaId(Long id);

    List<Curso> findTop5ByOrderByFechaDesc();
}

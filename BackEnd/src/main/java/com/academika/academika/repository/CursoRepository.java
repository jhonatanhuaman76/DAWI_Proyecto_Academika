package com.academika.academika.repository;

import com.academika.academika.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findTop10ByOrderByFechaDesc();
    List<Curso> findTop10ByCategoriaIdOrderByFechaDesc(Long categoriaId);
    List<Curso> findByInstructorIdOrderByFechaDesc(Long instructorId);
}

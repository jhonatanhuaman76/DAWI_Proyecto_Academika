package com.academika.academika.repository;
import com.academika.academika.entity.TipoRolUser;
import com.academika.academika.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByIdAndRol(Long id, TipoRolUser rol);
    Optional<Usuario> findByEmail(String email);
}

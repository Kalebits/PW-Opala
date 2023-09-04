package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

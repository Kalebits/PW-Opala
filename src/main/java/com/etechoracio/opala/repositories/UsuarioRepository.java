package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Avaliacao;
import com.etechoracio.opala.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



}

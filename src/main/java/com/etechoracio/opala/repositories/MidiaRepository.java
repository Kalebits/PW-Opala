package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Midia;
import com.etechoracio.opala.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MidiaRepository extends JpaRepository<Midia, Long> {

    @Query("select u from Usuario u where u.id_Usuario = :idUsuario")
    List<Usuario> findAllMidias(long idUsuario);
}

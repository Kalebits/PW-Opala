package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MidiaRepository extends JpaRepository<Midia, Long> {

    @Query("select m.videoUrl from Midia m where m.id_usuario.id_Usuario = :idUsuario")
    //Colocar m.videoUrl da erro no ResponseEntity
    List<String> findAllMidias(long idUsuario);
}

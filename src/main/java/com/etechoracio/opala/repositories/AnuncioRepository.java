package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query("select an from Anuncio an where an.id_usuario.id_Usuario = :idUsuario")
    List<Anuncio> findAllAnunciosBy(Long idUsuario);
}

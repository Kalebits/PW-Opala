package com.etechoracio.opala.repositories;


import com.etechoracio.opala.entity.Avaliacao;

import com.etechoracio.opala.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query("select a from Avaliacao a where a.id_Usuario.id_Usuario = :idUsuario")
    List<Avaliacao> findAllAvaliacao(Long idUsuario);

    @Query("select AVG(nota) from Avaliacao a where a.id_Usuario.id_Usuario = :id ")
    double mediaA(Long id);

    /*@Query("select a from Avaliacao a INNER JOIN a.id_Usuario u INNER JOIN u.id_Usuario ORDER BY a.nota")
    List<Avaliacao> orderByAvaliacaoC();

    @Query("select a from Avaliacao a INNER JOIN a.id_Usuario u INNER JOIN u.id_Usuario ORDER BY a.nota DESC")
    List<Avaliacao> orderByAvaliacaoD();*/
}

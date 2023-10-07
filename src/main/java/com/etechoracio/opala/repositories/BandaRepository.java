package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Banda;
import com.etechoracio.opala.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BandaRepository extends JpaRepository<Banda, Long> {

   /* @Query("select b from Banda b INNER JOIN UsuBanda as ub ON " +
            "b.ID_BANDA = ub.ID_BANDA LEFT JOIN Usuario as u ON ub.ID_USUARIO = u.ID_USUARIO " +
            "where u.ID_USUARIO = :idUsuario")

    List<Banda> findAllBandas(long idUsuario);*/
}

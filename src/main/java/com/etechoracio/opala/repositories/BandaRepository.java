package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Banda;
import com.etechoracio.opala.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface BandaRepository extends JpaRepository<Banda, Long> {

    @Query("select b from Banda b inner join Usuario ub on b.id = ub.bandas.idBanda " +
            "where ub.idUsuario = :idUsuario")
            //query banda
            /*"select b from Banda b INNER JOIN Usuario as u ON " +
            "b.ID_BANDA = u.bandas.idBanda" +
            "where u.ID_USUARIO = :idUsuario")*/
    List<Banda> findAllBandasByUser(Long idUsuario);
}

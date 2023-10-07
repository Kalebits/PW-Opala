package com.etechoracio.opala.repositories;


import com.etechoracio.opala.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    /* @Query("select * from Contrato c INNER JOIN UsuCont as uc ON " +
            "c.ID_CONTRATO = uc.ID_CONTRATO LEFT JOIN Usuario as u ON uc.ID_USUARIO = u.ID_USUARIO " +
            "where u.ID_USUARIO = :idUsuario")

    List<Contrato> findAllContratos(long idUsuario);*/
}

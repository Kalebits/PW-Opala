package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @Query("select p from Pagamento p INNER JOIN p.id_Contrato c INNER JOIN c.usuarios u where u.id_Usuario = :idUsuario")
    List<Pagamento> findAllPagamentosByUser(Long idUsuario);
}

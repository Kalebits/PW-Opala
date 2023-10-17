package com.etechoracio.opala.repositories;


import com.etechoracio.opala.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
   
}

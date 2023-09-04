package com.etechoracio.opala.repositories;


import com.etechoracio.opala.entity.Avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {



}

package com.etechoracio.opala.repositories;

import com.etechoracio.opala.entity.Banda;
import com.etechoracio.opala.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface BandaRepository extends JpaRepository<Banda, Long> {
}

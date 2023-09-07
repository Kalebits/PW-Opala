package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Banda;
import com.etechoracio.opala.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    @Autowired
    private BandaRepository bRepository;

    @GetMapping
    public List<Banda> buscarTodos(){
        return bRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Banda> findById(@PathVariable Long id){
        return bRepository.findById(id);
    }

    // find all by id
    // buscar id de banda com o id de usuario
}

package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Contrato;
import com.etechoracio.opala.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoRepository cRepository;

    @GetMapping
    public List<Contrato> buscarTodos(){return cRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Contrato> findById(@PathVariable Long id){
        return cRepository.findById(id);
    }
}

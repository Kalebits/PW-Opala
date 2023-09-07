package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Pagamento;
import com.etechoracio.opala.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pRepository;

    @GetMapping
    public List<Pagamento> buscarTodos(){ return pRepository.findAll();}

    @GetMapping(value = "/{id}")
    public Optional<Pagamento> findById(@PathVariable Long id){
        return pRepository.findById(id);
    }
}

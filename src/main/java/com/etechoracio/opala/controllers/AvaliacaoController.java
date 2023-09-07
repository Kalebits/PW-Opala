package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Avaliacao;
import com.etechoracio.opala.repositories.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository aRepository;

    @GetMapping
    public List<Avaliacao> buscarTodos(){
        return aRepository.findAll();
    }

    // find all by id
}

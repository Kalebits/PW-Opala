package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Midia;
import com.etechoracio.opala.repositories.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    @Autowired
    private MidiaRepository mRepository;

    @GetMapping
    public List<Midia> buscarTodos(){
        return mRepository.findAll();
    }

    // Find all by id
}

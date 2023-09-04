package com.etechoracio.opala.controllers;


import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository uRepository;

    @GetMapping
    public List<Usuario> buscarTodos(){
        return uRepository.findAll();
    }
}

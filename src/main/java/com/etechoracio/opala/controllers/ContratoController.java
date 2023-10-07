package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Contrato;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.ContratoRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoRepository cRepository;
    @Autowired
    private UsuarioRepository uRepository;

    @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) Long idUsuario){
        if(idUsuario == null){
            return ResponseEntity.ok(cRepository.findAll());
        }
        Optional<Usuario> existe = uRepository.findById(idUsuario);
        if(existe.isEmpty()){
            throw new IllegalArgumentException("Não existe um usúario com o id informado");
        }
    }

    @GetMapping(value = "/{id}")
    public Optional<Contrato> findById(@PathVariable Long id){
        return cRepository.findById(id);
    }
}

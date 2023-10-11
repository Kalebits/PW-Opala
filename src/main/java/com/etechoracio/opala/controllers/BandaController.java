package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Avaliacao;
import com.etechoracio.opala.entity.Banda;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.BandaRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    @Autowired
    private BandaRepository bRepository;

    @Autowired
    private UsuarioRepository uRepository;

  /*  @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) Long idUsuario){
        if(idUsuario == null){
            return ResponseEntity.ok(bRepository.findAll());
        }
        else
        {
            Optional<Usuario> existe = uRepository.findById(idUsuario);
            if(existe.isEmpty()){
                throw new IllegalArgumentException("Não existe um usúario com o id informado");
            }

        }
    }*/

    @GetMapping(value = "/{id}")
    public Optional<Banda> findById(@PathVariable Long id){
        return bRepository.findById(id);
    }



    // find all by id
    // buscar id de banda com o id de usuario
}

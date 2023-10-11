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

<<<<<<< HEAD
      @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {
            List<Banda> bandas = bRepository.findAllBandas(id);
            if (bandas.isEmpty()) {
                throw new IllegalArgumentException("Não existem bandas cadastradas para o usuário informado");
            }
            return ResponseEntity.ok(bandas);

=======
  /*  @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) Long idUsuario){
        if(idUsuario == null){
            return ResponseEntity.ok(bRepository.findAll());
>>>>>>> d9fa753d2b3646542061d960748ecaba82b8aade
        }
        else
        {
            throw new IllegalArgumentException("Não existe um usuário com o id informado");
        }
<<<<<<< HEAD


    }
=======
    }*/
>>>>>>> d9fa753d2b3646542061d960748ecaba82b8aade

    @GetMapping(value = "/{id}")
    public Optional<Banda> findById(@PathVariable Long id){
        return bRepository.findById(id);
    }



    // find all by id
    // buscar id de banda com o id de usuario
}

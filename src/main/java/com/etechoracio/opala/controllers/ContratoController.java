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
    public ResponseEntity<?> buscarTodos(){return ResponseEntity.ok(cRepository.findAll());}

    @GetMapping(value = "/{id}")
    public Optional<Contrato> findById(@PathVariable Long id){
        return cRepository.findById(id);
    }



    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodosContratosPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {
            List<Contrato> contratos = cRepository.findAllContratos(id);
            if (contratos.isEmpty()) {
                throw new IllegalArgumentException("Não existem contratos para o usuário informado");
            }
            return ResponseEntity.ok(contratos);
        }
        else
        {
            throw new IllegalArgumentException("Não existe um usuário com o id informado");
        }

    }
}

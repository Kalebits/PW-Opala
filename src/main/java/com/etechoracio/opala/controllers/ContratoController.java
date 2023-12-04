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
    public ResponseEntity<Contrato> buscarPorId(@PathVariable Long id){
        Optional<Contrato> existe = cRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodosContratosPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {
            List<Contrato> contratos = existe.get().getContratos();
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
    @PostMapping
    public ResponseEntity<Contrato> inserir(@RequestBody Contrato body){
        Contrato c1 = cRepository.save(body);
        return ResponseEntity.ok(c1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizar(@PathVariable Long id,
                                              @RequestBody Contrato contrato){
        Optional<Contrato> existe = cRepository.findById(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Contrato c1 = cRepository.save(contrato);
        return ResponseEntity.ok(c1);
    }

}

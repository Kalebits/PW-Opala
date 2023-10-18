package com.etechoracio.opala.controllers;


import com.etechoracio.opala.entity.Contrato;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository uRepository;

    @GetMapping
    public List<Usuario> buscarTodos(){
        return uRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Optional<Usuario> existe = uRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario body){
        Usuario u1 = uRepository.save(body);
        return ResponseEntity.ok(u1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id,
                                             @RequestBody Usuario usuario){
        Optional<Usuario> existe = uRepository.findById(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Usuario u1 = uRepository.save(usuario);
        return ResponseEntity.ok(u1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        Optional<Usuario> existe = uRepository.findById(id);
        if(existe.isPresent()){
            List<Contrato> contratos = existe.get().getContratos();
            /*if(!contratos.isEmpty() &&
                    existe.get().getContratos().get().getDt_Apresentacao().isAfter(LocalDate.now())) {
                throw new RuntimeException()
            }
Seria algo do tipo mas não pesquisei nada a respeito de como corrigir
            */
            uRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}

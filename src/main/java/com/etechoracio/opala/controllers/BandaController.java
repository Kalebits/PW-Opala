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

    @GetMapping
    public List<Banda> buscarTodos(){return bRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Banda> buscarPorId(@PathVariable Long id){
        Optional<Banda> existe = bRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get()) : ResponseEntity.notFound().build();
    }

      @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
          Optional<Usuario> existe = uRepository.findById(id);
          if (existe.isPresent()) {
              List<Banda> bandas = existe.get().getBandas();
              if (bandas.isEmpty()) {
                  throw new IllegalArgumentException("Não existem bandas cadastradas para o usuário informado");
              }
              return ResponseEntity.ok(bandas);
          }
          else {
              throw new IllegalArgumentException("Não existe um usuário com o id informado");
          }
      }

      @PostMapping
    public ResponseEntity<Banda> inserir(@RequestBody Banda body){
        Banda b1 = bRepository.save(body);
        return ResponseEntity.ok(b1);
      }

    @PutMapping("/{id}")
    public ResponseEntity<Banda>  atualizar(@PathVariable Long id,
                                            @RequestBody Banda banda){
        Optional<Banda> existe = bRepository.findById(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Banda b1 = bRepository.save(banda);
        return ResponseEntity.ok(b1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        boolean existe = bRepository.existsById(id);
        if (existe) {
            bRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}

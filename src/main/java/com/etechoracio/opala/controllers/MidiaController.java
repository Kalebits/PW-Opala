package com.etechoracio.opala.controllers;

import com.etechoracio.opala.dto.MidiaDTO;
import com.etechoracio.opala.entity.Midia;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.MidiaRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    @Autowired
    private MidiaRepository mRepository;

    @Autowired
    private UsuarioRepository uRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(mRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Midia> buscarPorId(@PathVariable Long id) {
        Optional<Midia> existe = mRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodasMidiasPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {

            List<MidiaDTO> midias = mRepository.findAllMidias(id).stream().map(e -> modelMapper.map(e, MidiaDTO.class)).collect(Collectors.toList());
            if (midias.isEmpty()) {
                throw new IllegalArgumentException("Não existem midias cadastradas para o usuário informado");
            }
            return ResponseEntity.ok(midias);
//ResponseEntity não funciona retornando um unico campo do banco
        } else {
            throw new IllegalArgumentException("Não existe um usuário com o id informado");
        }
    }

    @PostMapping
    public ResponseEntity<Midia> inserir(@RequestBody Midia body) {
        Midia m1 = mRepository.save(body);
        return ResponseEntity.ok(m1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Midia> atualizar(@PathVariable Long id,
                                           @RequestBody Midia midia) {
        Optional<Midia> existe = mRepository.findById(id);
        if (existe.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        //Não sei se precisaria editar o videoURL, pq n sei se poderia, mas vou deixar para editar oq quiser por enq
        Midia m1 = mRepository.save(midia);
        return ResponseEntity.ok(m1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        boolean existe = mRepository.existsById(id);
        if (existe) {
            mRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}

    // Find all by id


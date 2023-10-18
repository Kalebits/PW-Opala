package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Avaliacao;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.AvaliacaoRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository aRepository;

    @Autowired
    private UsuarioRepository uRepository;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscartodasAvaliacoesPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {
            List<Avaliacao> avaliacao = aRepository.findAllAvaliacao(id);
            if (avaliacao.isEmpty()) {
                throw new IllegalArgumentException("Não existem avaliações feitas para a o usuário cadastrado");
            }
            return ResponseEntity.ok(avaliacao);
        } else {
            throw new IllegalArgumentException("Não existe um usuário com o id informado");
        }
    }

    @PostMapping
    public ResponseEntity<Avaliacao> inserir(@RequestBody Avaliacao body) {
        Avaliacao a1 = aRepository.save(body);
        return ResponseEntity.ok(a1);
    }

    //Acho que não pode editar avaliação

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        boolean existe = aRepository.existsById(id);
        if (existe) {
            aRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
        }

    }

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
    @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) Long idUsuario){
        if(idUsuario == null){
            return ResponseEntity.ok(aRepository.findAll());
        }
        else
        {
            Optional<Usuario> existe = uRepository.findById(idUsuario);
            if(existe.isEmpty()){
                throw new IllegalArgumentException("Não existe um usúario com o id informado");
            }
            List<Avaliacao> avaliacoes = aRepository.findAllAvaliacao(idUsuario);
            if(avaliacoes.isEmpty()){
                throw new IllegalArgumentException("Não existe nenhuma avaliação do usuario informado");
            }
            return ResponseEntity.ok(avaliacoes);
        }
    }
}

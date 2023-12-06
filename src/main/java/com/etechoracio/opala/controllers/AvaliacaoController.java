package com.etechoracio.opala.controllers;

import com.etechoracio.opala.dto.AvaliacaoDTO;
import com.etechoracio.opala.entity.Avaliacao;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.AvaliacaoRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository aRepository;

    @Autowired
    private UsuarioRepository uRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/media/{id}")
    public ResponseEntity<?> mediaNotas(@PathVariable Long id){
        double media = aRepository.mediaA(id);
        AvaliacaoDTO avDTO = new AvaliacaoDTO();

        if (media > 0) {
            avDTO.setNota(media);
        } else {
            avDTO.setNota(0); // Pode ser outro valor padrão
        }
        return ResponseEntity.ok(avDTO);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscartodasAvaliacoesPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {
            List<Avaliacao> avaliacoes = aRepository.findAllAvaliacao(id);
            if (avaliacoes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Não existem avaliações feitas para o usuário cadastrado");

            }
            return ResponseEntity.ok(avaliacoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe um usuário com o ID informado");

        }
    }

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody Avaliacao body) {
        try {
            Avaliacao a1 = aRepository.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(a1); // Retorna a avaliação inserida
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao inserir a avaliação: " + e.getMessage());
        }
    }

    //Acho que não pode editar avaliação

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            boolean existe = aRepository.existsById(id);
            if (existe) {
                aRepository.deleteById(id);
                return ResponseEntity.ok().body("Avaliação excluída com sucesso.");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir a avaliação: " + e.getMessage());
        }



    }
    }

package com.etechoracio.opala.controllers;

import com.etechoracio.opala.dto.AnuncioDTO;
import com.etechoracio.opala.entity.Anuncio;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.AnuncioRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anRepository;

    @Autowired
    private UsuarioRepository uRepository;

    ModelMapper modelMapper = new ModelMapper();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> buscarTodos(){

            List<AnuncioDTO> todosAnuncios = anRepository.findAll().stream().map(e -> modelMapper.map(e, AnuncioDTO.class)).collect(Collectors.toList());
            if(todosAnuncios.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(todosAnuncios);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            Optional<Anuncio> existe = anRepository.findById(id);
            if (existe.isPresent()) {
                Anuncio anuncio = existe.get();

                return ResponseEntity.ok(anuncio); // ou anuncioDTO se mapeado para DTO
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Tratamento de exceção genérica
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar o Anúncio.");
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodosAnunciosPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if(existe.isPresent()){
            List<Anuncio> anuncios = anRepository.findAllAnunciosBy(id);

            if(anuncios.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(anuncios);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não existem midias cadastradas para o usuário informado");

    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        boolean existe = mRepository.existsById(id);
        if (existe) {
            mRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        boolean existe = anRepository.existsById(id);
        if (existe){
            anRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}

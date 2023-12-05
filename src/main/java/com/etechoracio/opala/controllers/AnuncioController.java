package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Anuncio;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.AnuncioRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anRepository;

    @Autowired
    private UsuarioRepository uRepository;

    ModelMapper modelMapper = new ModelMapper();
    public ResponseEntity<?> buscarTodos(){return ResponseEntity.ok(anRepository);}

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Anuncio> existe = anRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodosAnunciosPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if(existe.isPresent()){
            List<Anuncio> anuncios = anRepository.findAllAnunciosBy(id)
                    .stream().map(e -> modelMapper.map(e, Anuncio.class)).collect(Collectors.toList());

            if(anuncios.isEmpty()){
                throw new IllegalArgumentException("Não existem midias cadastradas para o usuário informado");
            }

            return ResponseEntity.ok(anuncios);
        }
        throw new IllegalArgumentException("Não existem midias cadastradas para o usuário informado");
    }
}

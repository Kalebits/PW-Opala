package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Midia;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    @Autowired
    private MidiaRepository mRepository;

    @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) long idUsuario) {

        if (idUsuario == 0L) {
            return ResponseEntity.ok(mRepository.findAll());
        }
        else
        {
        Optional<Midia> existe = mRepository.findById(idUsuario);
        if (existe.isPresent()) {
            List<Usuario> midias = mRepository.findAllMidias(idUsuario);
            if (!midias.isEmpty()) {
                throw new IllegalArgumentException("Não existem midias cadastradas para o usúario informado");
            }
            return ResponseEntity.ok(midias);
        }
        else
        {
            ResponseEntity.notFound().build();
        }
        }
        return ResponseEntity.notFound().build();
    }
    // Find all by id
}

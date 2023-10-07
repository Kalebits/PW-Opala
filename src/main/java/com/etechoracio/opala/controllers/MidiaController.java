package com.etechoracio.opala.controllers;

import com.etechoracio.opala.entity.Midia;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.MidiaRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
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

    @Autowired
    private UsuarioRepository uRepository;

    @GetMapping
    public ResponseEntity<?> buscarTodos(@RequestParam(required = false) Long id) {

        if (id == null) {
            return ResponseEntity.ok(mRepository.findAll());
        }
        else
        {
            Optional<Usuario> existe = uRepository.findById(id);
            if (existe.isPresent()) {
                List<Midia> midias = mRepository.findAllMidias(id);
                if (midias.isEmpty()) {
                    throw new IllegalArgumentException("Não existem midias cadastradas para o usúario informado");
                }
                return ResponseEntity.ok(midias);
                //ResponseEntity não funciona retornando um unico campo do banco
            }
            else
            {
                throw new IllegalArgumentException("Não existe um usúario com o id informado");
            }
        }
    }
    // Find all by id
}

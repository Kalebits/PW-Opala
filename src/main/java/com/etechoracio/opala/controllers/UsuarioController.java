package com.etechoracio.opala.controllers;


import com.etechoracio.opala.dto.UsuarioDTO;
import com.etechoracio.opala.dto.UsuarioUpdateDTO;
import com.etechoracio.opala.entity.Contrato;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.enumm.ExcludeEnum;
import com.etechoracio.opala.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.net.URI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

        @Autowired
        private UsuarioRepository uRepository;

        ModelMapper modelMapper = new ModelMapper();

        @CrossOrigin(origins = "http://localhost:4200") // Replace with your allowed origin
        @GetMapping
        public ResponseEntity<?> buscarTodos(){
            List<UsuarioDTO> usuarios = uRepository.findAll().stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
            return ResponseEntity.ok(usuarios);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<?> buscarPorId(@PathVariable Long id){

            Optional<Usuario> existe = uRepository.findById(id);
            if(existe.isPresent()){
                UsuarioDTO usuarioDTO = modelMapper.map(existe.get(), UsuarioDTO.class);
                return ResponseEntity.ok(usuarioDTO);
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("não existe usuario para o ID informado.");
            }
        }

    @CrossOrigin(origins = "http://localhost:4200")
        @PostMapping
        public ResponseEntity<?> inserir(@RequestBody UsuarioDTO body){
            try {


                Usuario u1 = convertUsuarioDTOtoUsuario(body);
                Usuario usuario = uRepository.save(u1);
                return ResponseEntity.ok().body(usuario);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro ao inserir o usuário: " + e.getMessage());
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> atualizar(@PathVariable Long id,
                                                 @RequestBody UsuarioUpdateDTO usuario){
            Optional<Usuario> existe = uRepository.findById(id);

            if(existe.isPresent()){
                Usuario existente = existe.get();
                if (usuario.getCep() != null){
                    existente.setCep(usuario.getCep());
                }

                if (usuario.getFoto() != null){
                    existente.setFoto(usuario.getFoto());
                }

                if (usuario.getEmail() != null){
                    existente.setEmail(usuario.getEmail());
                }

                uRepository.save(existente);
                return ResponseEntity.ok().build();
            }


            return ResponseEntity.notFound().build();

        }

        @PatchMapping("/{id}")
        public ResponseEntity<?> excluir(@PathVariable Long id,
                                         @RequestBody Usuario exclude){
            Optional<Usuario> existe = uRepository.findById(id);
            if(existe.isPresent()){
                List<Contrato> contratos = existe.get().getContratos();
                if(!contratos.isEmpty() ){
                    for (Contrato c: contratos) {
                        if(c.getDt_Apresentacao().isAfter(LocalDate.now()))
                            return ResponseEntity.badRequest().body("Não é possível excluir devido a contratos ativos.");
                    }
                }
                Usuario existente = existe.get();
                existente.setExclusao(exclude.getExclusao());
                uRepository.save(existente);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();

        }


        @CrossOrigin(origins = "http://localhost:4200")
        @PostMapping(value = "/login")
        public ResponseEntity<?> buscarPorEmail(@RequestBody UsuarioDTO login){
            List<UsuarioDTO> cadastro;



            if(login.getEmail() != null && !login.getEmail().isEmpty()){
                cadastro = uRepository.findUsuarioByEmail(login.getEmail())
                        .stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
                }else if(login.getCpf() != null && !login.getCpf().isEmpty()){
                cadastro = uRepository.findUsuarioByCPF(login.getCpf())
                        .stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
            }
            else {
                throw new IllegalArgumentException("Email ou CPF não fornecidos");
            }
                if(cadastro.isEmpty()){
                    throw new IllegalArgumentException("Usuário não encontrado");
                }
            UsuarioDTO usuarioEncontrado = cadastro.get(0);

            if (!usuarioEncontrado.getSenha().equals(login.getSenha())) {
                throw new IllegalArgumentException("Senha incorreta");
            }

            return ResponseEntity.ok(login);

            }

    public Usuario convertUsuarioDTOtoUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setTelefone(usuarioDTO.getTelefone());



        return usuario;
    }


}

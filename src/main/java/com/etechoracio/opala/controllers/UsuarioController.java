package com.etechoracio.opala.controllers;


import com.etechoracio.opala.dto.UsuarioDTO;
import com.etechoracio.opala.dto.UsuarioUpdateDTO;
import com.etechoracio.opala.entity.Contrato;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.enumm.ExcludeEnum;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository uRepository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<?> buscarTodos(){
        List<UsuarioDTO> usuarios = uRepository.findAll().stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id){

        List<UsuarioDTO> existe = uRepository.findById(id).stream()
                .map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());

        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario body){
        Usuario u1 = uRepository.save(body);
        return ResponseEntity.ok(u1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id,
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
                        throw new RuntimeException();
                }
            }
            Usuario existente = existe.get();
            existente.setExclusao(exclude.getExclusao());
            uRepository.save(existente);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> buscarPorEmail(@RequestBody UsuarioDTO login){

        if(login.getEmail().isEmpty()){

            List<UsuarioDTO> cadastro = uRepository.findUsuarioByCPF(login.getCpf()).stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());

            if(cadastro.isEmpty()){
                throw new IllegalArgumentException("Não existe usuario com esse CPF");
            }
            else{
                List<UsuarioDTO> senha = uRepository.findSenha(login.getSenha(), login.getEmail(), login.getCpf())
                        .stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());

                if(senha.isEmpty()){
                    throw new IllegalArgumentException("Senha incorreta");
                }
            }

        }
        else{
            List<UsuarioDTO> cadastro = uRepository.findUsuarioByEmail(login.getEmail()).stream()
                    .map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());

            if(cadastro.isEmpty()){
                throw new IllegalArgumentException("Não existe usuario com esse e-mail");
            }

            List<UsuarioDTO> senha = uRepository.findSenha(login.getSenha(), login.getEmail(), login.getCpf())
                    .stream().map(e -> modelMapper.map(e, UsuarioDTO.class)).collect(Collectors.toList());

            if(senha.isEmpty()){
                throw new IllegalArgumentException("Senha incorreta");
            }
        }

        return ResponseEntity.ok(login);
    }


}

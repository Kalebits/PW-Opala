package com.etechoracio.opala.controllers;

import com.etechoracio.opala.dto.PagamentoDTO;
import com.etechoracio.opala.entity.Pagamento;
import com.etechoracio.opala.entity.Usuario;
import com.etechoracio.opala.repositories.PagamentoRepository;
import com.etechoracio.opala.repositories.UsuarioRepository;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pRepository;

    @Autowired
    private UsuarioRepository uRepository;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<Pagamento> buscarTodos() {
        return pRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable Long id) {
        Optional<Pagamento> existe = pRepository.findById(id);
        return existe.isPresent() ? ResponseEntity.ok(existe.get())
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarTodasMidiasPorUsuario(@PathVariable Long id) {

        Optional<Usuario> existe = uRepository.findById(id);
        if (existe.isPresent()) {


            List<PagamentoDTO> pagamentos = pRepository.findAllPagamentosByUser(id).
                    stream().map(e -> modelMapper.map(e, PagamentoDTO.class)).collect(Collectors.toList());

            if (pagamentos.isEmpty()) {
                throw new IllegalArgumentException("Não existem midias cadastradas para o usuário informado");
            }
            return ResponseEntity.ok(pagamentos);
//ResponseEntity não funciona retornando um unico campo do banco
        } else {
            throw new IllegalArgumentException("Não existe um usuário com o id informado");
        }
    }

    @PostMapping
    public ResponseEntity<Pagamento> inserir(@RequestBody Pagamento body){
        Pagamento p1 = pRepository.save(body);
        return ResponseEntity.ok(p1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizar(@PathVariable Long id,
                                               @RequestBody Pagamento pagamento){
        Optional<Pagamento> existe = pRepository.findById(id);
        if(existe.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        //if com o hash para saber se é o usuário que gerou o método, não sei se precisaria
        Pagamento p1 = pRepository.save(pagamento);
        return ResponseEntity.ok(p1);
    }


}

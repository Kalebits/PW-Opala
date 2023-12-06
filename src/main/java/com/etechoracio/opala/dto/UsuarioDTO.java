package com.etechoracio.opala.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id_Usuario;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String genero;


}

package com.etechoracio.opala.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDTO {

    private Long id_Usuario;
    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String foto;
    private Integer telefone;
    private Integer cpf;
}

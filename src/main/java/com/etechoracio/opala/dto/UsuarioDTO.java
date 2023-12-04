package com.etechoracio.opala.dto;

import com.etechoracio.opala.entity.Instrumento;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsuarioDTO {
    private String nome;
    private List<Instrumento> instrumentos;
    private Integer telefone;
}

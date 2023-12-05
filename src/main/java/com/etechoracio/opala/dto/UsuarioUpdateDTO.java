package com.etechoracio.opala.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    private Long id_Usuario;
    private Long cep;
    private String email;
    private String foto;

}

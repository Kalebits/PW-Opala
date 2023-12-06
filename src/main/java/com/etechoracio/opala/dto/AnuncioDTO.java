package com.etechoracio.opala.dto;

import com.etechoracio.opala.enumm.TipoAnuncio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AnuncioDTO {

    private Long id;
    private String descricao;
    private LocalDate data;
    private TipoAnuncio tipo;
}

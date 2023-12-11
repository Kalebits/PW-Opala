package com.etechoracio.opala.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AnuncioResponseDTO {

    private List<AnuncioDTO> contratantes;
    private List<AnuncioDTO> artistas;

}

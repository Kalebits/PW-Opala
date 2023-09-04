package com.etechoracio.opala.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Habilidade {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Habilidade")
    @Id
    private Long Id_Habilidade;

    @Column(name="DESCRICAO")
    private String descricao;

    @Column(name = "Id_Usuario")
    private Usuario Id;
}

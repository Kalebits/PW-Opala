package com.etechoracio.opala.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_contrato")
    @Id
    private long Id_Contrato;

    @Column(name = "dt_Cont")
    private LocalDate dt_Cont;

    @Column(name = "Duracao")
    private int duracao;

    @Column(name = "dt_Apresentacao")
    private LocalDate dt_Apresentacao;

}

package com.etechoracio.opala.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pagamento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pagamento")
    @Id
    private Long Id_Pagamento;

    @Column(name = "Valor")
    private double valor;

    @Column(name = "metodo")
    private String metodo;

    @Column(name = "Id_Contrato")
    private Contrato id_Contrato;
}

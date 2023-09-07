package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Pagamento")
public class Pagamento {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    @Id
    private Long id_Pagamento;

    @Column(name = "Valor")
    private double valor;

    @Column(name = "metodo")
    private String metodo;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    private Contrato id_Contrato;
}

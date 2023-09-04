package com.etechoracio.opala.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "Id_UsuCont", joinColumns =
            {@JoinColumn(name = "Id_Usuario")}, inverseJoinColumns =
            {@JoinColumn(name="Id_Contrato")})
    private List<Usuario> usuarios;

}

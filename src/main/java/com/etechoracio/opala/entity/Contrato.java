package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="Contrato")
public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTRATO")
    @Id
    private long id_Contrato;

    @Column(name = "dt_Cont")
    private LocalDate dt_Cont;

    @Column(name = "Duracao")
    private int duracao;

    @Column(name = "dt_Apresentacao")
    private LocalDate dt_Apresentacao;

    @ManyToMany
    @JoinTable(name = "UsuCont", joinColumns =
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns =
            {@JoinColumn(name="ID_CONTRATO")})
    private List<Usuario> usuarios;

}

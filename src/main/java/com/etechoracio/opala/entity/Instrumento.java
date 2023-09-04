package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TBL_Instrumento ")

public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Instrumento")
    private Long Id_Instrumento;

    @Column(name="descricao")
    private String descricao;

    @ManyToMany
    @JoinTable(name = "Id_UsuInst", joinColumns =
            {@JoinColumn(name = "Id_Usuario")}, inverseJoinColumns =
            {@JoinColumn(name="Id_Instrumento")})
    private List<Usuario> usuarios;
}

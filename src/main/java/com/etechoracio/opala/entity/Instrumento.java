package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Instrumento ")
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSTRUMENTO")
    private Long id_Instrumento;

    @Column(name="descricao")
    private String descricao;

    @ManyToMany
    @JoinTable(name = "UsuInst", joinColumns =
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns =
            {@JoinColumn(name="ID_INSTRUMENTO")})
    private List<Usuario> usuarios;
}

package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Banda {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="Id_Banda")
    private Long Id_Banda;

    @Column (name="NomeBanda")
    private String NomeBanda;

    @Column (name="Estilo")
    private String Estilo;

    @ManyToMany
    @JoinTable(name = "Id_UsuBanda", joinColumns =
            {@JoinColumn(name = "Id_Usuario")}, inverseJoinColumns =
            {@JoinColumn(name="Id_Banda")})
    private List<Usuario> usuarios;
}

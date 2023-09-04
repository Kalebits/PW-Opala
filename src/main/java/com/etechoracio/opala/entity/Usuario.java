package com.etechoracio.opala.entity;

import com.etechoracio.opala.Enum.CategoriaEnum;
import com.etechoracio.opala.Enum.TipoGenero;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name="TBL_USUARIO")

public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="Id_Usuario")
    private Long Id_Usuario;

    @Column(name="Nome")
    private String nome;

    @Column(name="Email")
    private String email;

    @Column(name="Senha")
    private double senha;

    @Column(name="endereco")
    private String endereco;

    @Column(name="tipoUsuario")
    @Enumerated(EnumType.STRING)
    private CategoriaEnum tipoUsuario;

    @Column(name="genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;

}

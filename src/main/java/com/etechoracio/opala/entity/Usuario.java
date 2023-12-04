package com.etechoracio.opala.entity;


import com.etechoracio.opala.enumm.CategoriaEnum;
import com.etechoracio.opala.enumm.ExcludeEnum;
import com.etechoracio.opala.enumm.TipoGenero;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name="Usuario")
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID_USUARIO")
    private Long id_Usuario;

    @Column(name="Nome")
    private String nome;

    @Column(name="Email")
    private String email;

    @Column(name="Senha")
    private String senha;

    @Column(name="Telefone")
    private Integer telefone;

    @Column(name="Endereco")
    private String endereco;

    @Column(name="tipoUsuario")
    @Enumerated(EnumType.STRING)
    private CategoriaEnum tipoUsuario;

    @Column(name="genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;

    @Column(name = "exclusao", columnDefinition = "varchar(9) default 'ATIVO'")
    @Enumerated(EnumType.STRING)
    private ExcludeEnum exclusao = ExcludeEnum.ATIVO;

    //@Column(name = "notaFinal")
    //private double notaF;

    @ManyToMany
    @JoinTable(name="UsuInst", joinColumns=
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns=
            {@JoinColumn(name = "ID_INSTRUMENTO")})
    private List<Instrumento> instrumentos;

    @ManyToMany
    @JoinTable(name="UsuBanda", joinColumns=
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns=
            {@JoinColumn(name = "ID_BANDA")})
    private List<Banda> bandas;

    @ManyToMany
    @JoinTable(name="UsuCont", joinColumns=
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns=
            {@JoinColumn(name = "ID_CONTRATO")})
    private List<Contrato> contratos;


}

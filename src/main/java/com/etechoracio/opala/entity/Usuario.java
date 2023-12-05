package com.etechoracio.opala.entity;


import com.etechoracio.opala.dto.MidiaDTO;
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

    @Column(name="foto", columnDefinition = "varchar(max) default 'cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png'")
    private String foto = "cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"; // Foto feita

    @Column(name="descricao")
    private String descricao; // Descricao feita

    @Column(name="Telefone")
    private Integer telefone;

    @Column(name="Endereco")
    private String endereco;

    @Column(name="CEP")
    private Long cep;

    @Column(name="genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;

    @Column(name = "exclusao", columnDefinition = "varchar(9) default 'ATIVO'")
    @Enumerated(EnumType.STRING)
    private ExcludeEnum exclusao = ExcludeEnum.ATIVO;

    //@Column(name = "notaFinal")
    //private double notaF;

    @ManyToMany
    @JoinTable(name="UsuCont", joinColumns=
            {@JoinColumn(name = "ID_USUARIO")}, inverseJoinColumns=
            {@JoinColumn(name = "ID_CONTRATO")})
    private List<Contrato> contratos;

    @OneToMany
    @JoinColumn(name="ID_Midia")
    private List<Midia> midias;

}

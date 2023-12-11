package com.etechoracio.opala.entity;


import com.etechoracio.opala.dto.MidiaDTO;
import com.etechoracio.opala.enumm.ExcludeEnum;
import com.etechoracio.opala.enumm.TipoGenero;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

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

    @Column(name="cpf")
    private String cpf;

    @Column(name="Email")
    private String email;

    @Column(name="Senha")
    private String senha;

    public static String senhaCripto(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean verificaSenha(String senhaDigitada, String senhaBanco) {
        return BCrypt.checkpw(senhaDigitada, senhaBanco);
    }

    @Column(name="foto", columnDefinition = "varchar(max) default 'cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png'")
    private String foto = "cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"; // Foto feita

    @Column(name="descricao")
    private String descricao; // Descricao feita

    @Column(name="Telefone")
    private String telefone;

    @Column(name="Endereco")
    private String endereco;

    @Column(name="CEP")
    private Long cep;

    @Column(name="genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero genero = TipoGenero.FEMININO;

    @Column(name = "exclusao", columnDefinition = "varchar(9) default 'ATIVO'")
    @Enumerated(EnumType.STRING)
    private ExcludeEnum exclusao = ExcludeEnum.ATIVO;

    @OneToMany(mappedBy = "id_usuario")
    @JsonIgnore
    private List<Contrato> contratos;

    @OneToMany(mappedBy = "id_usuario")
    @JsonIgnore
    private List<Anuncio> anuncios;

    @OneToMany
    @JoinColumn(name="ID_Midia")
    private List<Midia> midias;

}

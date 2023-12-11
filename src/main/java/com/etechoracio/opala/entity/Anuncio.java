package com.etechoracio.opala.entity;


import com.etechoracio.opala.enumm.ExcludeEnum;
import com.etechoracio.opala.enumm.TipoAnuncio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="Anuncio")
public class Anuncio {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_Anuncio")
    private Long id_Anuncio;

    @Column(name="descricao")
    private String descricao;

    @Column(name="data")
    private LocalDate data;

    @Column(name="tipo")
    @Enumerated(EnumType.STRING)
    private TipoAnuncio tipo;

    @Column(name = "exclusao", columnDefinition = "varchar(9) default 'ATIVO'")
    @Enumerated(EnumType.STRING)
    private ExcludeEnum exclusao = ExcludeEnum.ATIVO;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    @JsonIgnore
    private Usuario id_usuario;

    public Anuncio ativarDesativar() {
        if(this.exclusao == ExcludeEnum.ATIVO){
            this.exclusao = ExcludeEnum.EXCLUIDO;
        }else{
            this.exclusao = ExcludeEnum.ATIVO;
        }
        return this;
    }
}

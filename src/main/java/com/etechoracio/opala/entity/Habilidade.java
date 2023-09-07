package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Habilidade")
public class Habilidade {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HABILIDADE")
    @Id
    private Long id_Habilidade;

    @Column(name="DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario id_usuario;
}

package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}

package com.etechoracio.opala.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliacao {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Avaliacao")
    private Long Id_Avaliacao;

    @Column(name = "Comentario")
    private String comentario;

    @Column(name = "Nota")
    private double nota;

    @Column(name = "Id_Usuario")
    private Usuario id_Usuario;
}

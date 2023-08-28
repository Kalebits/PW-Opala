package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

public class UsuInst {

    @JoinColumn(name="ID_UsuInst")
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Instrumento Id;


    @Column (name = "Id_Usuario")
    private Usuario usuario;



    
}

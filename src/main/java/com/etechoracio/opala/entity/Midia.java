package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Midia {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Midia")
    @Id
    private Long Id_Midia;

    @Column(name = "videoUrl")
    private String videoUrl;

    @Column(name = "Descricao")
    private String Descricao;

    @Column(name = "Id_Usuario")
    private Usuario id;

}

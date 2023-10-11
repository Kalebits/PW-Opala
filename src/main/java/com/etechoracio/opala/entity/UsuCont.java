package com.etechoracio.opala.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
@Entity
public class UsuCont implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_UsuCont")
    @Id
    private Long id_UsuCont;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario id_usuario;

    @ManyToOne
    @JoinColumn(name = "ID_CONTRATO")
    private Contrato id_Contrato;
}

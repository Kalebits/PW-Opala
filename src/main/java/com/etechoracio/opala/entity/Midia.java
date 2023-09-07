package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Midia")
public class Midia {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MIDIA")
    @Id
    private Long id_Midia;

    @Column(name = "videoUrl")
    private String videoUrl;

    @Column(name = "Descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario id_usuario;

}

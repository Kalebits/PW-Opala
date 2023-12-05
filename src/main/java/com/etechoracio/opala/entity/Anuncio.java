package com.etechoracio.opala.entity;


import com.etechoracio.opala.enumm.TipoAnuncio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Anuncio")
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

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario id_usuario;
}

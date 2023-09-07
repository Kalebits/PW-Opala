package com.etechoracio.opala.entity;

import com.etechoracio.opala.entity.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Avaliacao")
public class Avaliacao {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_AVALIACAO")
    private Long id_Avaliacao;

    @Column(name = "Comentario")
    private String comentario;

    @Column(name = "Nota")
    private double nota;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    public Usuario id_Usuario;

}

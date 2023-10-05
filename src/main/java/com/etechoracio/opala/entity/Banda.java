package com.etechoracio.opala.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Banda")
public class Banda {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="ID_BANDA")
    private Long id_Banda;

    @Column (name="NomeBanda")
    private String nomeBanda;

    @Column (name="Estilo")
    private String estilo;

    @ManyToMany(mappedBy = "bandas")
    private List<Usuario> usuarios;
}

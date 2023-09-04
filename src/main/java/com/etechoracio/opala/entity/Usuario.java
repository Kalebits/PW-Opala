package com.etechoracio.opala.entity;

import com.etechoracio.opala.Enum.CategoriaEnum;
import com.etechoracio.opala.Enum.TipoGenero;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name="TBL_USUARIO")

public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="Id_Usuario")
    private Long Id_Usuario;

    @Column(name="Nome")
    private String nome;

    @Column(name="Email")
    private String email;

    @Column(name="Senha")
    private double senha;

    @Column(name="endereco")
    private String endereco;

    @Column(name="tipoUsuario")
    @Enumerated(EnumType.STRING)
    private CategoriaEnum tipoUsuario;

    @Column(name="genero")
    @Enumerated(EnumType.STRING)
    private TipoGenero genero;

    @ManyToMany
    @JoinTable(name="Id_UsuInst", joinColumns={
            @JoinColumn(name = "Id_Usuario")}, inverseJoinColumns = {
            @JoinColumn(name = "Id_Instrumento")})
    private List<Instrumento> instrumentos;

    @ManyToMany
    @JoinTable(name="Id_UsuBanda", joinColumns={
            @JoinColumn(name = "Id_Usuario")}, inverseJoinColumns = {
            @JoinColumn(name = "Id_Banda")})
    private List<Banda> bandas;

    @ManyToMany
    @JoinTable(name="Id_UsuCont", joinColumns={
            @JoinColumn(name = "Id_Usuario")}, inverseJoinColumns = {
            @JoinColumn(name = "Id_Contrato")})
    private List<Contrato> contratos;



}

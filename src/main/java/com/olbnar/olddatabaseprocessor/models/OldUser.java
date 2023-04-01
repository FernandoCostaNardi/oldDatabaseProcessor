package com.olbnar.olddatabaseprocessor.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuario")
public class OldUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "banco")
    private String banco;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "empresa")
    private String empresa;
}

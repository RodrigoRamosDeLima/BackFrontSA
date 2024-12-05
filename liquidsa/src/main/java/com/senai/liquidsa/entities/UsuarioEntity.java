package com.senai.liquidsa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "bio")
    private String bio;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;

    // Relacionamento com Postagem e outras entidades sem CascadeType.ALL
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PostagemEntity> postagens;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ComentarioEntity> comentarios;

    @OneToMany(mappedBy = "seguidor", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ConexaoEntity> seguindo;

    @OneToMany(mappedBy = "seguido", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ConexaoEntity> seguidores;

}

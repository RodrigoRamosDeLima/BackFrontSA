package com.senai.liquidsa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity(name = "postagem")
public class PostagemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private UsuarioEntity usuario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String conteudo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "postagem", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ComentarioEntity> comentarios;

    @OneToMany(mappedBy = "postagem", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CurtidaEntity> curtidas;

    @OneToOne
    @JoinColumn(name = "image_id")
    @JsonBackReference
    private FileEntity file;

}

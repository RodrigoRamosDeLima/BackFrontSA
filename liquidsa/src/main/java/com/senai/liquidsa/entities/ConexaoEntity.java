package com.senai.liquidsa.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table
@Entity(name = "conexao")
public class ConexaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seguidor_id", nullable = false)
    @JsonBackReference
    private UsuarioEntity seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id", nullable = false)
    @JsonBackReference
    private UsuarioEntity seguido;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

}

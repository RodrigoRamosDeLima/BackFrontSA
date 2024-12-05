package com.senai.liquidsa;


import com.senai.liquidsa.entities.CurtidaEntity;
import com.senai.liquidsa.entities.PostagemEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.CurtidaRepository;
import com.senai.liquidsa.repositories.PostagemRepository;
import com.senai.liquidsa.services.PostagemService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PostagemServiceTest {

    @InjectMocks
    private PostagemService postagemService;

    @Mock
    private CurtidaRepository curtidaRepository;

    @Mock
    private PostagemRepository postagemRepository;

    private UsuarioEntity usuario;
    private PostagemEntity postagem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Inicializando dados de teste
        usuario = UsuarioEntity.builder()
                .id(1L)
                .nome("Usuário Teste")
                .build();

        postagem = PostagemEntity.builder()
                .id(1L)
                .titulo("Título Teste")
                .conteudo("Conteúdo Teste")
                .build();
    }

 @Test
void testCurtirPostagemComSucesso() {
    // Arrange
    when(postagemRepository.findById(postagem.getId())).thenReturn(Optional.of(postagem));
    when(curtidaRepository.existsByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId())).thenReturn(false);

    // Act
    postagemService.atualizarCurtida(postagem.getId(), usuario);

    // Assert
    verify(curtidaRepository, times(1)).save(any(CurtidaEntity.class));
    verify(curtidaRepository, never()).deleteByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId());
}


}

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


import static org.mockito.Mockito.*;

class CurtidaServiceTest {

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
    void testAdicionarCurtida() {
        // Configuração para nova curtida
        when(postagemRepository.findById(postagem.getId())).thenReturn(Optional.of(postagem));
        when(curtidaRepository.existsByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId()))
                .thenReturn(false);

        postagemService.atualizarCurtida(postagem.getId(), usuario);

        verify(curtidaRepository, times(1)).save(any(CurtidaEntity.class));
        verify(curtidaRepository, never()).deleteByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId());
    }

    @Test
    void testRemoverCurtida() {
        // Configuração para remoção de curtida
        when(postagemRepository.findById(postagem.getId())).thenReturn(Optional.of(postagem));
        when(curtidaRepository.existsByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId()))
                .thenReturn(true);

        postagemService.atualizarCurtida(postagem.getId(), usuario);

        verify(curtidaRepository, times(1)).deleteByPostagem_IdAndUsuario_Id(postagem.getId(), usuario.getId());
        verify(curtidaRepository, never()).save(any(CurtidaEntity.class));
    }

    // @Test
    // void testPostagemNaoEncontrada() {
    //     when(postagemRepository.findById(postagem.getId())).thenReturn(Optional.empty());

    //     postagemService.atualizarCurtida(postagem.getId(), usuario);

    //     verify(curtidaRepository, never()).save(any(CurtidaEntity.class));
    //     verify(curtidaRepository, never()).deleteByPostagem_IdAndUsuario_Id(anyLong(), anyLong());
    // }
}

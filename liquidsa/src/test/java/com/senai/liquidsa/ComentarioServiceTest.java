package com.senai.liquidsa;



import com.senai.liquidsa.dtos.req.CreateComentarioDTO;
import com.senai.liquidsa.dtos.res.ShowComentarioDTO;
import com.senai.liquidsa.entities.ComentarioEntity;
import com.senai.liquidsa.entities.PostagemEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.ComentarioRepository;
import com.senai.liquidsa.repositories.PostagemRepository;
import com.senai.liquidsa.services.ComentarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComentarioServiceTest {

    @Mock
    private ComentarioRepository comentarioRepository;

    @Mock
    private PostagemRepository postagemRepository;

    @InjectMocks
    private ComentarioService comentarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarComentario() {
        CreateComentarioDTO dto = new CreateComentarioDTO(1L, "Comentário");
        UsuarioEntity usuario = UsuarioEntity.builder().id(1L).nome("Usuário").build();
        PostagemEntity postagem = PostagemEntity.builder().id(1L).titulo("Postagem").build();
        ComentarioEntity comentario = ComentarioEntity.builder().conteudo("Comentário").usuario(usuario).postagem(postagem).build();

        when(postagemRepository.findById(1L)).thenReturn(Optional.of(postagem));
        when(comentarioRepository.save(any(ComentarioEntity.class))).thenReturn(comentario);

        ShowComentarioDTO result = comentarioService.criarComentario(dto, usuario);

        assertNotNull(result);
        assertEquals("Comentário", result.getConteudo());
        verify(comentarioRepository, times(1)).save(any(ComentarioEntity.class));
    }
}

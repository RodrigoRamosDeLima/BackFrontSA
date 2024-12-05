package com.senai.liquidsa.services;

import com.senai.liquidsa.dtos.req.CreateComentarioDTO;
import com.senai.liquidsa.dtos.res.ShowComentarioDTO;
import com.senai.liquidsa.entities.ComentarioEntity;
import com.senai.liquidsa.entities.PostagemEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.ComentarioRepository;
import com.senai.liquidsa.repositories.PostagemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    private final PostagemRepository postagemRepository;

    public ShowComentarioDTO criarComentario(CreateComentarioDTO createComentarioDTO, UsuarioEntity loggedUser) {
        Optional<PostagemEntity> optionalPostagem = postagemRepository.findById(createComentarioDTO.getPostagemId());
        if (optionalPostagem.isPresent()) {
            PostagemEntity postagem = optionalPostagem.get();
            ComentarioEntity comentario = comentarioRepository
                    .save(
                            ComentarioEntity
                                    .builder()
                                    .postagem(postagem)
                                    .usuario(loggedUser)
                                    .conteudo(createComentarioDTO.getConteudo())
                                    .build()
                    );
            return ShowComentarioDTO
                    .builder()
                    .conteudo(comentario.getConteudo())
                    .dataCriacao(comentario.getDataCriacao())
                    .build();
        }
        return null;
    }

    public List<ShowComentarioDTO> listarComentarios(Long postagemId) {
        return comentarioRepository.findByPostagem_Id(postagemId)
                .stream()
                .map(comentario ->
                        ShowComentarioDTO
                                .builder()
                                .conteudo(comentario.getConteudo())
                                .dataCriacao(comentario.getDataCriacao())
                                .build()).collect(Collectors.toList()
                );
    }

    public ShowComentarioDTO buscarComentarioPorId(Long id) {
        ComentarioEntity comentario = comentarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado"));

        return ShowComentarioDTO
                .builder()
                .conteudo(comentario.getConteudo())
                .dataCriacao(comentario.getDataCriacao())
                .build();
    }

    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}

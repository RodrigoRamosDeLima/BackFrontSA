package com.senai.liquidsa.services;

import com.senai.liquidsa.dtos.req.CreatePostagemDTO;
import com.senai.liquidsa.dtos.res.ShowPostagemDTO;
import com.senai.liquidsa.entities.CurtidaEntity;
import com.senai.liquidsa.entities.FileEntity;
import com.senai.liquidsa.entities.PostagemEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.ComentarioRepository;
import com.senai.liquidsa.repositories.CurtidaRepository;
import com.senai.liquidsa.repositories.PostagemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;
    private final ComentarioRepository comentarioRepository;
    private final CurtidaRepository curtidaRepository;

    public ShowPostagemDTO criarPostagem(
            CreatePostagemDTO createPostagemDTO,
            UsuarioEntity usuarioEntity,
            FileEntity fileEntity
    ) {
        PostagemEntity postagem = PostagemEntity
                .builder()
                .titulo(createPostagemDTO.getTitulo())
                .conteudo(createPostagemDTO.getConteudo())
                .usuario(usuarioEntity)
                .file(fileEntity)
                .build();

        postagem = postagemRepository.save(postagem);

        return fillShowPostagem(postagem, usuarioEntity);
    }

    public List<ShowPostagemDTO> listarPostagens(UsuarioEntity usuarioEntity) {
        List<PostagemEntity> postagens = postagemRepository.findAll();
        return postagens
                .stream()
                .map(postagem -> fillShowPostagem(postagem, usuarioEntity))
                .toList();
    }

    public ShowPostagemDTO buscarPostagemPorId(Long id, UsuarioEntity usuarioEntity) {
        PostagemEntity postagem = postagemRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Postagem não encontrada"));

        return fillShowPostagem(postagem, usuarioEntity);
    }

    public void atualizarCurtida(Long postagemId, UsuarioEntity usuarioEntity) {
        if (curtidaRepository.existsByPostagem_IdAndUsuario_Id(postagemId, usuarioEntity.getId())) {
            curtidaRepository.deleteByPostagem_IdAndUsuario_Id(postagemId, usuarioEntity.getId());
        } else {
            Optional<PostagemEntity> optionalPostagem = postagemRepository.findById(postagemId);

            if (optionalPostagem.isPresent()) {
                PostagemEntity postagem = optionalPostagem.get();
                curtidaRepository.save(
                        CurtidaEntity
                                .builder()
                                .usuario(usuarioEntity)
                                .postagem(postagem)
                                .dataCriacao(LocalDateTime.now())
                                .build()
                );
            }
        }
    }

    public void deletarPostagem(Long id) {
        postagemRepository.deleteById(id);
    }

    private ShowPostagemDTO fillShowPostagem(PostagemEntity postagem, UsuarioEntity usuarioEntity) {
        return ShowPostagemDTO
                .builder()
                .id(postagem.getId())
                .user(usuarioEntity.getNome())
                .title(postagem.getTitulo())
                .description(postagem.getConteudo())
                .imageId(postagem.getFile().getId())
                .likes(curtidaRepository.countByPostagem(postagem))
                .liked(curtidaRepository.existsByPostagemAndUsuario(postagem, usuarioEntity))
                .build();
    }
}

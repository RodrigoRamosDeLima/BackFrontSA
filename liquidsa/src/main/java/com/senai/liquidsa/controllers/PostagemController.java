package com.senai.liquidsa.controllers;

import com.senai.liquidsa.dtos.req.CreatePostagemDTO;
import com.senai.liquidsa.dtos.res.ShowPostagemDTO;
import com.senai.liquidsa.entities.FileEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.services.FileService;
import com.senai.liquidsa.services.PostagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<ShowPostagemDTO> criarPostagem(
            @RequestAttribute("loggedUser") UsuarioEntity usuarioEntity,
            @RequestBody CreatePostagemDTO createPostagemDTO
    ) {
        FileEntity fileEntity = fileService.getFileById(createPostagemDTO.getImageId());
        ShowPostagemDTO postagem = postagemService.criarPostagem(createPostagemDTO, usuarioEntity, fileEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(postagem);
    }

    @GetMapping
    public ResponseEntity<List<ShowPostagemDTO>> listarPostagens(
            @RequestAttribute("loggedUser") UsuarioEntity usuarioEntity
    ) {
        return ResponseEntity.ok(postagemService.listarPostagens(usuarioEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowPostagemDTO> buscarPostagemPorId(
            @PathVariable Long id,
            @RequestAttribute("loggedUser") UsuarioEntity usuarioEntity
    ) {
        ShowPostagemDTO postagem = postagemService.buscarPostagemPorId(id, usuarioEntity);
        return ResponseEntity.ok(postagem);
    }

    @GetMapping("/curtida/{id}")
    public ResponseEntity<Void> atualizarCurtida(
            @PathVariable Long id,
            @RequestAttribute("loggedUser") UsuarioEntity usuarioEntity
    ) {
        try {
            postagemService.atualizarCurtida(id, usuarioEntity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable Long id) {
        postagemService.deletarPostagem(id);
        return ResponseEntity.noContent().build();
    }
}

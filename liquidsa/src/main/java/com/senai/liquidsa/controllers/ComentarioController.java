package com.senai.liquidsa.controllers;

import com.senai.liquidsa.dtos.req.CreateComentarioDTO;
import com.senai.liquidsa.dtos.res.ShowComentarioDTO;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.services.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<ShowComentarioDTO> criarComentario(
            @RequestBody CreateComentarioDTO createComentarioDTO,
            @RequestAttribute(value = "loggedUser", required = false) UsuarioEntity loggedUser
    ) {
        ShowComentarioDTO comentario = comentarioService.criarComentario(createComentarioDTO, loggedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
    }

    @GetMapping("/{postagemId}")
    public ResponseEntity<List<ShowComentarioDTO>> listarComentarios(@PathVariable("postagemId") Long postagemId) {
        return ResponseEntity.ok(comentarioService.listarComentarios(postagemId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}

package com.senai.liquidsa.controllers;

import com.senai.liquidsa.dtos.req.CreateUsuarioDTO;
import com.senai.liquidsa.dtos.res.ShowUsuarioDTO;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.services.UsuarioService;
import com.senai.liquidsa.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final LoginUtil loginUtil;

    @GetMapping("/test")
    public ResponseEntity<UsuarioEntity> getUsuarioTest(@RequestAttribute("loggedUser") UsuarioEntity usuarioEntity) {
        return ResponseEntity.ok(usuarioEntity);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ShowUsuarioDTO> criarUsuario(@RequestBody @Validated CreateUsuarioDTO CreateUsuarioDTO) {
        try {
            ShowUsuarioDTO usuario = usuarioService.criarUsuario(CreateUsuarioDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<ShowUsuarioDTO> getUsuario(@RequestHeader String authorization) {
        ShowUsuarioDTO usuario = usuarioService.getUsuario(loginUtil.extractLogin(authorization));
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShowUsuarioDTO>> listarUsuarios() {
        List<ShowUsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowUsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        ShowUsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShowUsuarioDTO> atualizarUsuarioParcial(
            @RequestHeader String authorization,
            @RequestBody Map<String, Object> atualizacoes
    ) {
        ShowUsuarioDTO usuarioAtualizado = usuarioService
                .atualizarParcial(loginUtil.extractLogin(authorization), atualizacoes);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowUsuarioDTO> atualizarUsuarioCompleto(
            @PathVariable Long id,
            @RequestBody CreateUsuarioDTO createUsuarioDTO
    ) {
        try {
            ShowUsuarioDTO usuarioAtualizado = usuarioService.atualizarCompleto(id, createUsuarioDTO);

            return ResponseEntity.ok(usuarioAtualizado);
        } catch (NoSuchAlgorithmException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
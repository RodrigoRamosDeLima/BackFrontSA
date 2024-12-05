package com.senai.liquidsa.controllers;

import com.senai.liquidsa.dtos.req.LoginDTO;
import com.senai.liquidsa.services.UsuarioService;
import com.senai.liquidsa.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsuarioService usuarioService;
    private final LoginUtil loginUtil;

    @PostMapping
    public ResponseEntity<String> doLogin(@RequestBody LoginDTO loginDTO) {
        if (usuarioService.login(loginDTO)) {
            return ResponseEntity.ok(loginUtil.generateToken(loginDTO.getLogin()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }

    @GetMapping("/check")
    public void checkLogin() {
    }
}
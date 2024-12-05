package com.senai.liquidsa.runner;

import com.senai.liquidsa.repositories.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class AppRunner implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;

    public AppRunner(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}

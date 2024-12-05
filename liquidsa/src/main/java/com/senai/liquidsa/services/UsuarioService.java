package com.senai.liquidsa.services;

import com.senai.liquidsa.dtos.req.CreateUsuarioDTO;
import com.senai.liquidsa.dtos.req.LoginDTO;
import com.senai.liquidsa.dtos.res.ShowUsuarioDTO;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.UsuarioRepository;
import com.senai.liquidsa.util.LoginUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final LoginUtil loginUtil;

    public ShowUsuarioDTO criarUsuario(CreateUsuarioDTO createUsuarioDTO) throws NoSuchAlgorithmException {
        UsuarioEntity usuario = usuarioRepository.save(fillUsuario(createUsuarioDTO));

        return fillShowUsuario(usuario);
    }

    public ShowUsuarioDTO getUsuario(String login) {
        return usuarioRepository
                .findByLogin(login)
                .map(this::fillShowUsuario)
                .orElse(null);

    }

    public UsuarioEntity getFullUsuario(Optional<UsuarioEntity> usuarioEntity) throws EntityNotFoundException {
        return usuarioEntity.orElse(null);
    }

    public List<ShowUsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios
                .stream()
                .map(this::fillShowUsuario)
                .toList();
    }

    public ShowUsuarioDTO buscarUsuarioPorId(Long id) {
        UsuarioEntity usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        return fillShowUsuario(usuario);
    }

    public ShowUsuarioDTO atualizarParcial(String login, Map<String, Object> atualizacoes) {
        UsuarioEntity usuario = usuarioRepository
                .findByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Aplicar as alterações nos campos fornecidos
        if (atualizacoes.containsKey("nome")) usuario.setNome((String) atualizacoes.get("nome"));
        if (atualizacoes.containsKey("email")) usuario.setEmail((String) atualizacoes.get("email"));

        if (atualizacoes.containsKey("senha")) {
            try {
                usuario.setSenha(loginUtil.encryptPassword(atualizacoes.get("senha").toString()));
            } catch (NoSuchAlgorithmException ignored) {
            }
        }
        if (atualizacoes.containsKey("bio")) usuario.setBio((String) atualizacoes.get("bio"));

        // Salva as alterações no banco de dados
        usuario = usuarioRepository.save(usuario);

        return fillShowUsuario(usuario);
    }

    public ShowUsuarioDTO atualizarCompleto(Long id, CreateUsuarioDTO createUsuarioDTO) throws NoSuchAlgorithmException {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        // Atualiza todos os campos do usuário
        usuario.setNome(createUsuarioDTO.getNome());
        usuario.setEmail(createUsuarioDTO.getEmail());
        usuario.setSenha(loginUtil.encryptPassword(createUsuarioDTO.getSenha()));
        usuario.setBio(createUsuarioDTO.getBio());

        // Salva as alterações no banco de dados
        usuario = usuarioRepository.save(fillUsuario(createUsuarioDTO));

        // Converte para ShowUsuarioDTO
        ShowUsuarioDTO response = new ShowUsuarioDTO();
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        response.setBio(usuario.getBio());

        return response;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioEntity fillUsuario(CreateUsuarioDTO createUsuarioDTO) throws NoSuchAlgorithmException {
        return UsuarioEntity
                .builder()
                .nome(createUsuarioDTO.getNome())
                .login(createUsuarioDTO.getLogin())
                .email(createUsuarioDTO.getEmail())
                .senha(loginUtil.encryptPassword(createUsuarioDTO.getSenha()))
                .bio(createUsuarioDTO.getBio())
                .build();
    }

    private ShowUsuarioDTO fillShowUsuario(UsuarioEntity usuario) {
        return ShowUsuarioDTO
                .builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .bio(usuario.getBio())
                .build();
    }

    public Boolean login(LoginDTO loginDTO) {
        boolean login = false;

        try {
            login = usuarioRepository.existsByLoginAndSenha(
                    loginDTO.getLogin(),
                    loginUtil.encryptPassword(loginDTO.getPassword())
            );
        } catch (NoSuchAlgorithmException ignored) {
        }

        if (login) {
            usuarioRepository.logged(loginDTO.getLogin(), LocalDateTime.now());
        }

        return login;
    }


}

package com.senai.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senai.liquidsa.entities.UsuarioEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Boolean existsByLoginAndSenha(String login, String senha);

    Optional<UsuarioEntity> findByLogin(String login);

    @Transactional
    @Modifying
    @Query("UPDATE usuario SET ultimoLogin = :date WHERE login = :login")
    void logged(@Param("login") String login, @Param("date") LocalDateTime data);

}

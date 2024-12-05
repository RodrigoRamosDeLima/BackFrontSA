package com.senai.liquidsa.repositories;

import com.senai.liquidsa.entities.CurtidaEntity;
import com.senai.liquidsa.entities.PostagemEntity;
import com.senai.liquidsa.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CurtidaRepository extends JpaRepository<CurtidaEntity, Long> {

    Long countByPostagem(PostagemEntity postagem);

    Boolean existsByPostagemAndUsuario(PostagemEntity postagem, UsuarioEntity usuario);

    Boolean existsByPostagem_IdAndUsuario_Id(Long postagemId, Long usuarioId);

    @Transactional
    @Modifying
    void deleteByPostagem_IdAndUsuario_Id(Long postagemId, Long usuarioId);

}

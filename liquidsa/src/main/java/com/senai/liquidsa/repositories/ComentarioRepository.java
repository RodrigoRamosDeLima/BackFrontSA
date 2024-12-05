package com.senai.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.liquidsa.entities.ComentarioEntity;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Long> {

    List<ComentarioEntity> findByPostagem_Id(Long postagem_id);

}

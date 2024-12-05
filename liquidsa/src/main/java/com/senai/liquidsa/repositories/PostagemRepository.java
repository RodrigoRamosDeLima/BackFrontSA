package com.senai.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.liquidsa.entities.PostagemEntity;

@Repository
public interface PostagemRepository  extends JpaRepository<PostagemEntity, Long>{
    
}

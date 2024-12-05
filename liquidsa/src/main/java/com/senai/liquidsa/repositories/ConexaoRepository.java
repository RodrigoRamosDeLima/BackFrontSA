package com.senai.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.liquidsa.entities.ConexaoEntity;

@Repository
public interface ConexaoRepository extends JpaRepository<ConexaoEntity, Long>{
    
}

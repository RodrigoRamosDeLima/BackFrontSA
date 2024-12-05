package com.senai.liquidsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.liquidsa.entities.NotificacaoEntity;

@Repository
public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long>{


    
}

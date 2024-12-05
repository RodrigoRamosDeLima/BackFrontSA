package com.senai.liquidsa.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShowComentarioDTO {
    
    private String conteudo;
    private LocalDateTime dataCriacao;

}

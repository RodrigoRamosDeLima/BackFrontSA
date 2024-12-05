package com.senai.liquidsa.dtos.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateComentarioDTO {

    private Long postagemId;

    private String conteudo;

}

package com.senai.liquidsa.dtos.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateUsuarioDTO {

    private String nome;

    private String login;

    private String email;

    private String senha;

    @Nullable
    private String bio;

}

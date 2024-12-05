package com.senai.liquidsa.dtos.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ShowUsuarioDTO {

    private String nome;
    private String email;
    private String bio;

}

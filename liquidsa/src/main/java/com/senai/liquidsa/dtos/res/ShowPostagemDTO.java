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
public class ShowPostagemDTO {

    private Long id;

    private String user;

    private String title;

    private String description;

    private Long imageId;

    private Long likes;

    private Boolean liked;

}

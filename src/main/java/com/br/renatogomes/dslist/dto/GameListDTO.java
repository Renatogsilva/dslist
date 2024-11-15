package com.br.renatogomes.dslist.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class GameListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}

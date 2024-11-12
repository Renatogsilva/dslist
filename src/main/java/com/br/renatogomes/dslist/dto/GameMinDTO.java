package com.br.renatogomes.dslist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class GameMinDTO implements Serializable {

    private Long id;
    private String title;
    private Integer year;
    private String imageUrl;
    private String shortDescription;
}

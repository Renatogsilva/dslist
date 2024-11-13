package com.br.renatogomes.dslist.dto;

import com.br.renatogomes.dslist.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public GameDTO(Game game){
        BeanUtils.copyProperties(game,this);
    }

    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
}
package com.JoaoMarcos.dsList.DTO;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.JoaoMarcos.dsList.classes.Game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameByIdDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameByIdDto(Game game){
        BeanUtils.copyProperties(game, this);
        /*Este método copia tudo que está no game para o game by id dto */
    }
}

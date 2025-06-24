package com.JoaoMarcos.dsList.DTO;

import com.JoaoMarcos.dsList.classes.Game;
import com.JoaoMarcos.dsList.projections.GameMinProjection;

import lombok.Getter;

@Getter
public class GameDto {
    
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDto(){

    }

    public GameDto(Game game){
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    public GameDto(GameMinProjection game){
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }
}


package com.JoaoMarcos.dsList.DTO;

import java.io.Serializable;
import com.JoaoMarcos.dsList.classes.GameList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class GameListDto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;

    public GameListDto(GameList game){
        this.id = game.getId();
        this.name = game.getName();
    }
}


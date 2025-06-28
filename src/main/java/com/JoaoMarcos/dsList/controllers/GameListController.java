package com.JoaoMarcos.dsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JoaoMarcos.dsList.DTO.GameDto;
import com.JoaoMarcos.dsList.DTO.GameListDto;
import com.JoaoMarcos.dsList.DTO.ReplacementDto;
import com.JoaoMarcos.dsList.services.GameListService;
import com.JoaoMarcos.dsList.services.GameService;

@RestController
@RequestMapping(value = "/game_list")
public class GameListController {
    
    @Autowired
    public GameListService gameListService;

    @Autowired
    public GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameDto> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{game_list_id}/replacement")
    public void replacementMoveGameList(@PathVariable Long game_list_id, 
      @RequestBody ReplacementDto body){

        gameListService.replacementPositionGame(body.getSourceIndex(), 
         body.getDestinationIndex(), game_list_id);
    }
}

package com.JoaoMarcos.dsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JoaoMarcos.dsList.DTO.GameListDto;
import com.JoaoMarcos.dsList.services.GameListService;

@RestController
@RequestMapping(value = "/game_list")
public class GameListController {
    
    @Autowired
    public GameListService gameListService;

    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }
    
}

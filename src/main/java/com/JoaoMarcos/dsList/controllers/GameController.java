package com.JoaoMarcos.dsList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JoaoMarcos.dsList.DTO.GameByIdDto;
import com.JoaoMarcos.dsList.DTO.GameDto;
import com.JoaoMarcos.dsList.services.GameService;
@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    public GameService gameService;
    
    
    @GetMapping(value = "/{id}")
    public GameByIdDto findById(@PathVariable Long id){
        return gameService.fingById(id);
    }


    @GetMapping
    public List<GameDto> findAll(){
        return gameService.findAll();
    }
    
}

package com.JoaoMarcos.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JoaoMarcos.dsList.DTO.GameDto;
import com.JoaoMarcos.dsList.classes.Game;
import com.JoaoMarcos.dsList.repositories.GameRepository;

@Service
public class GameService {
    
   @Autowired
   public GameRepository gameRepository;

   public List<GameDto> findAll(){
    List<Game> result = gameRepository.findAll();
    return result.stream().map(x -> new GameDto(x)).toList();

    /*Eu tô pegando cada elemento dentro da lista de games e passando ele como
     * argumento para o construtor do GameDto, transformando assim um Game em
     * GameDto*/
   }
}

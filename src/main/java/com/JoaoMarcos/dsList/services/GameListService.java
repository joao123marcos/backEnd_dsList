package com.JoaoMarcos.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.JoaoMarcos.dsList.DTO.GameListDto;
import com.JoaoMarcos.dsList.classes.GameList;
import com.JoaoMarcos.dsList.repositories.GameListRepository;

@Service
public class GameListService {
    
   @Autowired
   public GameListRepository gameListRepository;
   
   @Transactional(readOnly = true)
   public List<GameListDto> findAll(){
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(x -> new GameListDto(x)).toList();

    /*Eu tô pegando cada elemento dentro da lista de games e passando ele como
     * argumento para o construtor do GameDto, transformando assim um Game em
     * GameDto*/
   }
}

package com.JoaoMarcos.dsList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JoaoMarcos.dsList.DTO.GameDto;
import com.JoaoMarcos.dsList.DTO.GameListDto;
import com.JoaoMarcos.dsList.classes.GameList;
import com.JoaoMarcos.dsList.projections.GameMinProjection;
import com.JoaoMarcos.dsList.repositories.GameListRepository;
import com.JoaoMarcos.dsList.repositories.GameRepository;

@Service
public class GameListService {
    
   @Autowired
   public GameListRepository gameListRepository;

   @Autowired
   public GameRepository gameRepository;
   
   @Transactional(readOnly = true)
   public List<GameListDto> findAll(){
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(x -> new GameListDto(x)).toList();

    /*Eu tô pegando cada elemento dentro da lista de games e passando ele como
     * argumento para o construtor do GameDto, transformando assim um Game em
     * GameDto*/
   }

   @Transactional
   public void replacementPositionGame(int sourceIndex, int destinationIndex, Long game_list_id){
    
      //Todo este trecho eu estou manipulando a lista em memória
      List<GameMinProjection> list = gameRepository.searchByList(game_list_id);
      GameMinProjection obj = list.get(sourceIndex);
      list.remove(sourceIndex);
      list.add(destinationIndex, obj);
      //Fim do trecho que manipula a lista em memória

      int min = sourceIndex < destinationIndex ? sourceIndex :  destinationIndex;
      int max = sourceIndex < destinationIndex ? destinationIndex :  sourceIndex;

      for (int i = min; i <= max; i++) {
         gameListRepository.updateBelongingPosition(game_list_id, list.get(i).getId(), i);
      }
   }
}

package com.JoaoMarcos.dsList.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.JoaoMarcos.dsList.DTO.GameListDto;
import com.JoaoMarcos.dsList.classes.GameList;
import com.JoaoMarcos.dsList.projections.GameMinProjection;
import com.JoaoMarcos.dsList.repositories.GameListRepository;
import com.JoaoMarcos.dsList.repositories.GameRepository;
import com.JoaoMarcos.dsList.services.exceptions.IndexOfBoundsException;
import com.JoaoMarcos.dsList.services.exceptions.ResourceNotFoundException;

@Service
public class GameListService {

   @Autowired
   public GameListRepository gameListRepository;

   @Autowired
   public GameRepository gameRepository;

   @Transactional(readOnly = true)
   public List<GameListDto> findAll() {
      List<GameList> result = gameListRepository.findAll();
      return result.stream().map(x -> new GameListDto(x)).toList();

      /*
       * Eu tô pegando cada elemento dentro da lista de games e passando ele como
       * argumento para o construtor do GameDto, transformando assim um Game em
       * GameDto
       */
   }

   @Transactional(readOnly = true)
   public GameListDto findById(Long id) {
      if (id <= 0) {
         throw new IndexOfBoundsException("Id game list out of valid range");
      } else {
         Optional<GameList> op = gameListRepository.findById(id);

         if (op.isPresent()) {
            GameList gameList = op.get();
            return new GameListDto(gameList);
         } else {
            throw new ResourceNotFoundException(id);
         }
      }
   }

   @Transactional
   public void replacementPositionGame(int sourceIndex, int destinationIndex, 
     Long game_list_id) {

      List<GameMinProjection> list = null;
      GameMinProjection obj = null;

      Optional<GameList> listDto = gameListRepository.findById(game_list_id);

      if (listDto.isPresent()) {
         // Todo este trecho eu estou manipulando a lista em memória
         list = gameRepository.searchByList(game_list_id);
         if ((sourceIndex <= list.size()) && (destinationIndex <= list.size() )) {

            obj = list.get(sourceIndex);
            list.remove(sourceIndex);
            list.add(destinationIndex, obj);

            // Fim do trecho que manipula a lista em memória
            int min = sourceIndex < destinationIndex ? 
              sourceIndex : destinationIndex;
            int max = sourceIndex < destinationIndex ? 
              destinationIndex : sourceIndex;

            for (int i = min; i <= max; i++) {
              gameListRepository.updateBelongingPosition(game_list_id, 
              list.get(i).getId(), i);
            }
         }else{
            throw new IndexOfBoundsException("Source index or destination index "+
             "out of valid range");
         }
      }else{
         throw new IndexOfBoundsException("Game list id out of valid range");

      }
   }
}

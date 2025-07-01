package com.JoaoMarcos.dsList.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JoaoMarcos.dsList.DTO.GameByIdDto;
import com.JoaoMarcos.dsList.DTO.GameDto;
import com.JoaoMarcos.dsList.classes.Game;
import com.JoaoMarcos.dsList.projections.GameMinProjection;
import com.JoaoMarcos.dsList.repositories.GameRepository;
import com.JoaoMarcos.dsList.services.exceptions.IndexOfBoundsException;
import com.JoaoMarcos.dsList.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {

   @Autowired
   public GameRepository gameRepository;

   @Autowired
   public GameListService gameListService;

   @Transactional(readOnly = true)
   public GameByIdDto fingById(Long id) {
      if (id <= 0) {
         throw new IndexOfBoundsException("Game id out of valid range");
      } else {
         Optional<Game> optionalGame = gameRepository.findById(id);

         if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return new GameByIdDto(game);

         } else {
            throw new ResourceNotFoundException(id);
         }
      }
   }

   @Transactional(readOnly = true)
   public List<GameDto> findAll() {
      try {
         /*
          * Eu tô pegando cada elemento dentro da lista de games e passando ele
          * como argumento para o construtor do GameDto, transformando assim um
          * Game em GameDto
          */

         List<Game> result = gameRepository.findAll();
         return result.stream().map(x -> new GameDto(x)).toList();

      } catch (RuntimeException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }

   @Transactional(readOnly = true)
   public List<GameDto> findByList(Long listId) {

      gameListService.findById(listId);
      List<GameMinProjection> result = gameRepository.searchByList(listId);
      return result.stream().map(x -> new GameDto(x)).toList();
   }
}

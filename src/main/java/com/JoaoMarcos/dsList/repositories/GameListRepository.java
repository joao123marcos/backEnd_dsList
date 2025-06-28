package com.JoaoMarcos.dsList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.JoaoMarcos.dsList.classes.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true, value = 
     "UPDATE tb_belonging SET position = :newPosition WHERE game_list_id = :game_list_id "+
     "AND game_id = :gameId")
     
    void updateBelongingPosition(Long game_list_id, Long gameId, Integer newPosition);

}

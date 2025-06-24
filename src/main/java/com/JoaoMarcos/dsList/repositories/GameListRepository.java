package com.JoaoMarcos.dsList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JoaoMarcos.dsList.classes.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}

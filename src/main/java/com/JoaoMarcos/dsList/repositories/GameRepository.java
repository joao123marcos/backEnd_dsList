package com.JoaoMarcos.dsList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JoaoMarcos.dsList.classes.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}

package com.JoaoMarcos.dsList.classes;

import java.io.Serializable;

import com.JoaoMarcos.dsList.classes.pk.BelongingPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(){
    }

    public Belonging(Game game, GameList list, Integer position){
        this.position = position;
        id.setGame(game);
        id.setList(list);
    }

    public Game getGame(){
        return id.getGame();
    }

    public void setGame(Game game){
        id.setGame(game);
    }

    public GameList GameList (){
        return id.getList();
    }

    public void setGameList(GameList gameList){
        id.setList(gameList);
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging other = (Belonging) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}

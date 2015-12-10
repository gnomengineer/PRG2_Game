package GameObjects;


import GameObjects.Figur;
import GameObjects.Map;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre
 */
public class SaveGame implements Serializable {
    Map map = null;
    Figur player = null;
    Figur opponent = null;
    boolean isOpponentContining = false;
    
    public SaveGame()
    {} 
    
    public SaveGame(Map map, Figur player, Figur opponent, boolean isOpponentContining)   
    {
        this.map = map;
        this.player =player;
        this.opponent = opponent;
        this.isOpponentContining = isOpponentContining;
    }
    
    public Map getMap(){
        return map;
    }
    
    public Figur getPlayer(){
        return player;
    }
    
    public Figur getOpponent(){
        return opponent;
    }
    
    public boolean IsOpponentContining()
    {
        return isOpponentContining;
    }       
}

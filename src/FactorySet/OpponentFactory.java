package FactorySet;

import Enums.GameModeEnum;
import Interfaces.OpponentInterface;
import ArtificialIntelligence.AIController;
import Network.NetworkController;
import java.io.IOException;
/**
 *
 * @author Daniel
 */
public class OpponentFactory {
    
    public OpponentFactory(){
        
    }
    
    public OpponentInterface createOpponent(GameModeEnum type){
        
            switch(type){
                case AIMode:
                    return new AIController();
                case MultiplayerClientMode:
                    try{
                        return new NetworkController("");
                    } catch (IOException ioe){
                        System.err.println("ERROR: " + ioe.getMessage());
                    }
                case MultiplayerServerMode:
                    try{
                        //@TODO implement different network controller for server mode
                        return new NetworkController("");
                    } catch (IOException ioe){
                        System.err.println("ERROR: " + ioe.getMessage());
                    }
                default:
                    throw new UnsupportedOperationException("wrong type given");
            }
        
    }
}

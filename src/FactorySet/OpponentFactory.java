package FactorySet;

import Enums.GameModeEnum;
import Interfaces.OpponentInterface;
import ArtificialIntelligence.AIController;
import Network.NetworkController;
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
                return new NetworkController();
            case MultiplayerServerMode:
                //@TODO implement different network controller for server mode
                return new NetworkController();
            default:
                throw new UnsupportedOperationException("wrong type given");
        }
    }
}

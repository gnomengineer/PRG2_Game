package FactorySet;

import Enums.GameModeEnum;
import Interfaces.OpponentInterface;
import ArtificialIntelligence.AIController;
import Enums.MessageTypeEnum;
import GameObjects.Map;
import Logger.Logger;
import Network.NetworkController;
import java.io.IOException;
/**
 *
 * @author Daniel
 */
public class OpponentFactory {
    
    public OpponentFactory(){
        
    }
    
    public OpponentInterface createOpponent(GameModeEnum type, Map map, int port, String addr){
        
            switch(type){
                case AIMode:
                    return new AIController(map);
                case MultiplayerClientMode:
                    try{
                        return new NetworkController(port, addr);
                    } catch (IOException ioe){
                        Logger.logToConsole(MessageTypeEnum.Error, ioe);
                    }
                case MultiplayerServerMode:
                    try{
                        return new NetworkController(port);
                    } catch (IOException ioe){
                        Logger.logToConsole(MessageTypeEnum.Error, ioe);
                    }
                default:
                    throw new UnsupportedOperationException("wrong type given");
            }
        
    }
}

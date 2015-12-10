package Interfaces;

import GameObjects.Line;
import Enums.MessageTypeEnum;
/**
 * Interface between AI, Network and GameController.
 * 
 * @author Andre, Daniel
 */
public interface OpponentInterface 
{
    /**
     * 
     * sends the line object to the opponent.
     * 
     * @param selectedLine - gewählte Linie
     */
    void sendLine(Line selectedLine);

    /**
     * notifies Opponent about its turn.
     * 
    */
    void setOpponentTurn();    
}

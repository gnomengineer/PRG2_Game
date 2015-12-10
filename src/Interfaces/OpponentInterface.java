package Interfaces;

import GameObjects.Line;
import Enums.MessageTypeEnum;
/**
 *
 * @author Andre, Daniel
 */
public interface OpponentInterface 
{
    /**
     * 
     * sendet die gewählte Linie dem Opponent.
     * 
     * @param selectedLine - gewählte Linie
     */
    void sendGameInfo(Line selectedLine);

    /**
     * Opponent wird notifiziert, dass er nun am Zug ist.
     * 
    */
    void setOpponentTurn();    
}

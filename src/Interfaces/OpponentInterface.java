package Interfaces;

import GameObjects.Line;
import Enums.MessageTypeEnum;
/**
 *
 * @author Andre, Daniel
 */
public interface OpponentInterface 
{
    void sendGameInfo(Line selectedLine);
    void sendGameInfo(MessageTypeEnum msg);
    
    /**
     * Opponent wird notifiziert, dass er nun am Zug ist
     */
    void makeMove();    
}

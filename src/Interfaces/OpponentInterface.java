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
}

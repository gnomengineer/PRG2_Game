package Interfaces;

import GameObjects.Line;
/**
 *
 * @author Daniel
 */
public interface ObserverInterface{
    void makeMove(Line selectedLine, boolean isOpponent);
    void submitOptions();
}

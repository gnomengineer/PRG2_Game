package Interfaces;

import GameObjects.Line;
/**
 *
 * @author Daniel
 */
public interface ObserverInterface{
    /**
     * TODO: evtl. umbenennen - View und Opponent benützen diese Methode um eine Linie zusetzen.
     * @param selectedLine
     * @param isOpponent 
     */
    void makeMove(Line selectedLine, boolean isOpponent);
    
    /**
     * TODO: evtl. umbennen - Controller informieren, dass die Einstellungen übernommen werden können
     */
    void submitOptions();
}

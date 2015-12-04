package Interfaces;

import Enums.MessageTypeEnum;
import Enums.GameModeEnum;
import java.awt.event.ActionListener;

/**
 *
 * @author Andre
 */
public interface GameViewInterface {

    /**
     * Die gestzte Linie 
     * @return 
     */
    String getLastDrawnLine();
        
     /**
     * ActionListener registieren
     * @param actionListener 
     */
    void registerLineActionListener(ActionListener actionListener);
    
    /**
     * Spiel anhand Information aufbauen
     * @param width
     * @param height
     */
    void startGameView(int width, int height);
    
   
    
    /**
     * Linie zeichnen
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param isOpponent 
     */
    void drawLine(int startX, int startY, int endX, int endY, boolean isOpponent);
    
    /**
     * Spielstatus aktualisieren
     * @param points 
     */
    void updatePlayerState(int points);
    
    /**
     * Spielstatus aktualisieren
     * @param points 
     */
    void updateOpponentState(int points);

    /**
     * Nachricht anzeigen
     * @param message - nachricht, welche angezeigt werden soll
     * @param messageType typ der nachricht 
     */
    void showMessage(String message, MessageTypeEnum messageType);
}

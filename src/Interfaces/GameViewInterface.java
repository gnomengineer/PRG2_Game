package Interfaces;

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
     * Die IP-Adresse des Gegners
     * @return 
     */
    String getIPAddress();

    /**
     * Die Portnummer, welche definiert wurde
     * @return 
     */
    String getPortNumber();
    
    /**
     * ActionListener registieren
     * @param actionListener 
     */
    void registerOptionActionListener(ActionListener actionListener);
    
    /**
     * Spiel anhand Information aufbauen
     * @param width
     * @param height
     */
    void startGameView(int width, int height);
    
    /**
     * Die OptionView anzeigen
     */
    void startOptionView();
    
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

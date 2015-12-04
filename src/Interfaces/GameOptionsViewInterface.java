package Interfaces;

import Enums.GameModeEnum;
import java.awt.event.ActionListener;

/**
 *
 * @author Andre
 */
public interface GameOptionsViewInterface {
    
    /**
     * ActionListener registieren
     * @param actionListener 
     */
    void registerOptionActionListener(ActionListener actionListener); 
    
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
     * Feldbreite für die Initialisierung
     * @return 
     */
    int getFieldWidth();
    
    /**
     * Feldhöhe für die Initialisierung
     * @return 
     */
    int getFieldHeight();
    
      /**
     * Spielermode für die Initialisierung
     * @return 
     */
    GameModeEnum getGameMode();
    
     /**
     * Die OptionView anzeigen
     */
    void startOptionsView();
}

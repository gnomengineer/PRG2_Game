
import Interfaces.GameViewInterface;
import Interfaces.MessageTypeEnum;


/**
 *
 * @author Andre
 */
public class GameView implements GameViewInterface {
    @Override
    public void startGameView(int width, int height) {
        // hier grafikobjekte aufbaufbauen, welche du auch zuordnen kannst.
    }

    @Override
    public void startOptionView() {
        // die optionview anzeigen
    }

    @Override
    public void drawLine(int startX, int startY, int endX, int endY, boolean isOpponent) {
        // anhand isOppenent eine am anfang festgelegte Farbe verwenden
    }

    @Override
    public void updatePlayerState(int points) {
        // das TextControl updaten
    }

    @Override
    public void updateOpponentState(int points) {
        // das TextControl updaten
    }

    @Override
    public void showMessage(String message, MessageTypeEnum messageType) {
        // siehe MessageType
        // warning und information als MessageBox anzeigen, restart und end kannst du das spielfeld zurücksetzen
        // jedoch noch nicht ganz klar, was... evtl. restart heisst, das das Spiel von vorne beginnt, alle grafikobjekte reseten
    }

    @Override
    public void getIPAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPortNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

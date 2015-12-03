
import Enums.GameModeEnum;
import Enums.MessageTypeEnum;
import Interfaces.GameViewInterface;
import Enums.MessageTypeEnum;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Andre
 */
public class GameView implements GameViewInterface {
    
    JFrame jFrameGameView;
    JPanel jPanelGameView;
    JMenuBar jMBGameView;
    JMenu jMGame;
    JMenu jMHelp;
    JMenuItem jMIRules;
    JMenuItem jMIAbout;
    JMenuItem jMISave;
    JMenuItem jMIClose;
    
    
    public GameView(){
        jMBGameView= new JMenuBar();      
        jFrameGameView = new JFrame("Dots and Boxes");
        jPanelGameView = new JPanel();
        jMGame = new JMenu("Game");
        jMHelp = new JMenu("Help");
        jMIRules= new JMenuItem("Rules");
        jMIAbout = new JMenuItem("About");
        jMISave = new JMenuItem("Save");
        jMIClose = new JMenuItem("Close");
        setup();
        
        jFrameGameView.setVisible(true);
    }
    
    private void setup(){
        jFrameGameView.add(jPanelGameView);
        jPanelGameView.setLayout(new BorderLayout());
        
        //Menubar
        jFrameGameView.setJMenuBar(jMBGameView);
        jMBGameView.add(jMGame);
        jMBGameView.add(jMHelp);
        
        //Menu
        jMGame.add(jMISave);
        jMGame.add(jMIClose);
        jMHelp.add(jMIRules);
        jMHelp.add(jMIAbout);
        
    }
    
    
    
    @Override
    public void startGameView(int width, int height) {
        // hier grafikobjekte aufbaufbauen, welche du auch zuordnen kannst.
    }

    @Override
    public void startOptionView() {
        // die optionview anzeigen
        new GameOptionsView();
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
    public String getIPAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPortNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastDrawnLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerOptionActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFieldWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFieldHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameModeEnum getGameMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerLineActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}


import Enums.GameModeEnum;
import Enums.MessageTypeEnum;
import Interfaces.GameViewInterface;
import Enums.MessageTypeEnum;
import GameObjects.Line;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
    Dimension size;
    
    
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
        size = new Dimension(300, 200);
        setup();
        
        
    }
    
    private void setup(){
        jFrameGameView.add(jPanelGameView);
        jPanelGameView.setLayout(new BorderLayout());
        jFrameGameView.setSize(size);
        jFrameGameView.setPreferredSize(size);
        
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
        jFrameGameView.setVisible(true);
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
    public void registerLineActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastDrawnLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void drawLine(Line line, boolean isOpponent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

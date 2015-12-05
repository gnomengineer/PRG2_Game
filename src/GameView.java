
import Enums.GameModeEnum;
import Enums.MessageTypeEnum;
import Interfaces.GameViewInterface;
import Enums.MessageTypeEnum;
import GameObjects.Line;
import Interfaces.ObserverInterface;
import Interfaces.SubjectInterface;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.*;


/**
 *
 * @author Andre
 */
public class GameView implements GameViewInterface, SubjectInterface {
    //Frame
    JFrame jFrameGameView;
    JMenuBar jMBGameView;
    JMenu jMGame;
    JMenu jMHelp;
    JMenuItem jMIRules;
    JMenuItem jMIAbout;
    JMenuItem jMISave;
    JMenuItem jMIClose;
    Dimension size;
    MapView map1;
    
    JPanel jPanelCenter;
    JPanel jPanelScoreView;
    JPanel jPanelWest;
    
    JLabel jLabelScore;
    JLabel jLabelScoreOwn;
    JLabel jLabelScoreOpponent;
    JLabel jLabelScoreOwnPoints;
    JLabel jLabelScoreOpponentPoints;
    
  
    public GameView(){
        jMBGameView= new JMenuBar();      
        jFrameGameView = new JFrame("Dots and Boxes");
        jMGame = new JMenu("Game");
        jMHelp = new JMenu("Help");
        jMIRules= new JMenuItem("Rules");
        jMIAbout = new JMenuItem("About");
        jMISave = new JMenuItem("Save");
        jMIClose = new JMenuItem("Close");
        size = new Dimension(800, 800);
        jPanelCenter=new JPanel();
        jPanelScoreView=new JPanel();
        jPanelWest = new JPanel();
        jLabelScore=new JLabel("Score");
        jLabelScoreOwn = new JLabel("Your Points:");
        jLabelScoreOpponent = new JLabel ("Opponent Points:  ");
        jLabelScoreOwnPoints = new JLabel("0");
        jLabelScoreOpponentPoints = new JLabel("0");
        
            
        
        setup();
        
    }
    
    private void setup(){
        jFrameGameView.setSize(size);
        jFrameGameView.setPreferredSize(size);
        jFrameGameView.setLayout(new BorderLayout());
        jFrameGameView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrameGameView.add(jPanelCenter,BorderLayout.CENTER); 
        jFrameGameView.add(jPanelWest, BorderLayout.WEST);
        
        
        //Menubar
        jFrameGameView.setJMenuBar(jMBGameView);
        jMBGameView.add(jMGame);
        jMBGameView.add(jMHelp);
        
        //Menu
        jMGame.add(jMISave);
        jMGame.add(jMIClose);
        jMHelp.add(jMIRules);
        jMHelp.add(jMIAbout);
        
        //jPanelCenter
        jPanelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanelCenter.setLayout(new FlowLayout() );
        
        //jPanelWest
        jPanelWest.setLayout(new FlowLayout());
        jPanelWest.add(jPanelScoreView);
        jPanelWest.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //jPanelScoreView
        jPanelScoreView.setLayout(new GridLayout(2,2));
        jPanelScoreView.add(jLabelScoreOwn);
        jPanelScoreView.add(jLabelScoreOwnPoints);
        jPanelScoreView.add(jLabelScoreOpponent);
        jPanelScoreView.add(jLabelScoreOpponentPoints);
        
        
    }
    
    private void setupMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void startGameView(int width, int height) {
        map1= new MapView(width, height);
        jPanelCenter.add(map1);
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
        
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

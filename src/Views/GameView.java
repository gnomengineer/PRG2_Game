package Views;


import Interfaces.GameViewInterface;
import Enums.MessageTypeEnum;
import GameObjects.Line;
import Interfaces.ObserverInterface;
import Interfaces.SubjectInterface;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.File;
import javax.swing.*;
import static javax.swing.JFrame.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * GUI for Displaying Game. Does show Score stats of Player and Map.
 * Informs Observer which Line was clicked and sends LineToDraw to MapView
 * @author Martin Etterlin
 */
public class GameView implements GameViewInterface, SubjectInterface {
    //Frame
    JFrame jFrameGameView;
    
    //MenuBar
    JMenuBar jMBGameView;
    JMenu jMGame;
    JMenu jMHelp;
    JMenuItem jMIRules;
    JMenuItem jMIAbout;
    JMenuItem jMISave;
    JMenuItem jMIClose;
    JMenuItem jMIOpen;
    
    //JPanel
    JPanel jPanelCenter;
    JPanel jPanelScoreView;
    JPanel jPanelWest;
    
    //JLabel
    JLabel jLabelScore;
    JLabel jLabelScoreOwn;
    JLabel jLabelScoreOpponent;
    JLabel jLabelScoreOwnPoints;
    JLabel jLabelScoreOpponentPoints;
    ObserverInterface observer;
    
    //JFilechooser
    JFileChooser jFChooser;
    String openFileDirecotry;
    String saveFileDirectory;
    
    //Div
    Dimension size;
    MapView map1;
    
    public GameView(){
        jMBGameView= new JMenuBar();      
        jFrameGameView = new JFrame("Dots and Boxes");
        jMGame = new JMenu("Game");
        jMHelp = new JMenu("Help");
        jMIRules= new JMenuItem("Rules");
        jMIAbout = new JMenuItem("About");
        jMISave = new JMenuItem("Save");
        jMIClose = new JMenuItem("Close");
        jMIOpen = new JMenuItem("Open");
        size = new Dimension(800, 800);
        jPanelCenter=new JPanel();
        jPanelScoreView=new JPanel();
        jPanelWest = new JPanel();
        jLabelScore=new JLabel("Score");
        jLabelScoreOwn = new JLabel("Your Points:");
        jLabelScoreOpponent = new JLabel ("Opponent Points:  ");
        jLabelScoreOwnPoints = new JLabel("0");
        jLabelScoreOpponentPoints = new JLabel("0");
        jFChooser = new JFileChooser();
        setup();
        
        jFChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Dots And Box", "fdab", "fdab");
        jFChooser.setFileFilter(filter);
        jFChooser.setSelectedFile(new File("saveGame.fdab"));
    }
    /**
     * Sets up GUI Components for Game.
     */
    private void setup(){
        
        jFrameGameView.setLayout(new BorderLayout());
        jFrameGameView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrameGameView.add(jPanelCenter,BorderLayout.CENTER); 
        jFrameGameView.add(jPanelWest, BorderLayout.WEST);
        
        //Menubar
        jFrameGameView.setJMenuBar(jMBGameView);
        jMBGameView.add(jMGame);
        jMBGameView.add(jMHelp);
        
        //Menu
        jMGame.add(jMIOpen);
        jMGame.add(jMISave);
        jMGame.add(jMIClose);
        jMHelp.add(jMIRules);
        jMHelp.add(jMIAbout);
        
        jMISave.addActionListener((event)->{
                if(jFChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    saveFileDirectory=jFChooser.getSelectedFile().getAbsolutePath();
                }
                observer.saveGame(saveFileDirectory);
                //Parameter openFileDirectory kann noch mitgegeben werden
        });
        
        jMIOpen.addActionListener((event) -> {
            if(jFChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                openFileDirecotry= jFChooser.getSelectedFile().toString();
            }
            observer.openGame(openFileDirecotry);
        });
        
        jMIClose.addActionListener((event)->{
            System.exit(NORMAL);
        });
        
        
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

    
    @Override
    public void startGameView(int width, int height) {
        if(map1 != null)
        {
            jPanelCenter.remove(map1);
        }
        
        map1= new MapView(width, height);
        map1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                Point2D.Double point = new Point2D.Double(e.getX(),e.getY());               
                LineView line = map1.getLineViewByPoint(point);
                if(line != null && observer != null){
                    observer.makeMove(convertToLine(line), false);
                }
            }
        });
        
        jPanelCenter.add(map1);
        jFrameGameView.pack();
        jFrameGameView.setVisible(true);
    }
    
    private Line convertToLine(LineView lineView){
        int space = MapView.getSpace();
        Line line = new Line((int)(lineView.x1 / space), (int)(lineView.y1 / space),(int)(lineView.x2 / space),(int)(lineView.y2 / space));
        return line;
    }

    @Override
    public void updatePlayerState(int points) {
        jLabelScoreOwnPoints.setText(""+points);
    }

    @Override
    public void updateOpponentState(int points) {
        jLabelScoreOpponentPoints.setText(""+points);
    }

    @Override
    public void showMessage(String message, MessageTypeEnum messageType) {
        if(messageType.equals(MessageTypeEnum.Information)){
            JOptionPane.showMessageDialog(jPanelCenter, message, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(messageType.equals(MessageTypeEnum.Warning)){
            JOptionPane.showMessageDialog(jPanelCenter, message, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else if(messageType.equals(MessageTypeEnum.Restart)){
            JOptionPane.showMessageDialog(jPanelCenter, message, "Restart", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(messageType.equals(messageType.End)){
            JOptionPane.showMessageDialog(jPanelCenter, message, "End", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(messageType.equals(messageType.Error)){
            JOptionPane.showMessageDialog(jPanelCenter, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
        // siehe MessageType
        // warning und information als MessageBox anzeigen, restart und end kannst du das spielfeld zurücksetzen
        // jedoch noch nicht ganz klar, was... evtl. restart heisst, das das Spiel von vorne beginnt, alle grafikobjekte reseten
    }

    @Override
    public void drawLine(Line line, boolean isOpponent) {
        map1.drawLine(line, isOpponent);
        //map1.repaint(); 
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void updatePlayerTurn(boolean isOpponent) {
        if(isOpponent){
            jLabelScoreOpponent.setBackground(Color.YELLOW);
        }
        else{
            jLabelScoreOwn.setBackground(Color.YELLOW);
        }
       
    }

    @Override
    public void drawSquare(int x1, int y1, boolean isOpponent) {
    }
}

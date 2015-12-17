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
    JPanel jPanelTurnView;
    
    //JLabel
    JLabel jLabelScore;
    JLabel jLabelScoreOwn;
    JLabel jLabelScoreOpponent;
    JLabel jLabelScoreOwnPoints;
    JLabel jLabelScoreOpponentPoints;
    JLabel jLabelTurn;
    ObserverInterface observer;
    
    //JFilechooser
    JFileChooser jFChooser;
    String openFileDirecotry;
    String saveFileDirectory;
    
    //Map
    MapView map1;
    
    //Fonts
    Font fontScore;
    
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
        jPanelCenter=new JPanel();
        jPanelScoreView=new JPanel();
        jPanelWest = new JPanel();
        jPanelTurnView=new JPanel();
        jLabelScore=new JLabel("Score");
        jLabelScoreOwn = new JLabel("Your Points:");
        jLabelScoreOpponent = new JLabel ("Opponent Points:  ");
        jLabelScoreOwnPoints = new JLabel("0");
        jLabelScoreOpponentPoints = new JLabel("0");
        jLabelTurn= new JLabel("Turn");
        jFChooser = new JFileChooser();
        fontScore = new Font("Calibri", Font.BOLD, 20);
        setup();
    }
    /**
     * Sets up GUI Components for Game.
     */
    private void setup(){
        
        jFrameGameView.setLayout(new BorderLayout());
        jFrameGameView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrameGameView.add(jPanelCenter,BorderLayout.CENTER); 
        jFrameGameView.add(jPanelWest, BorderLayout.WEST);
        jFrameGameView.add(jPanelTurnView, BorderLayout.NORTH);
        
        confMenu();
        confJPanels();
        confJLabels();
        confJFileChooser();
    }
    //Private method to configure Menu
    private void confMenu(){
        
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
        
       
        jMIRules.addActionListener((event) -> {
          JOptionPane.showMessageDialog(null, "1st RULE: You do not talk about Dots & Boxes\n2nd RULE: You DO NOT talk about Dots & Boxes.\n3rd RULE: If someone says \"stop\" or goes limp, taps out the fight is over.\n4th RULE: Only two guys to a fight.\n5th RULE: One fight at a time.\n6th RULE: No shirts, no shoes.\n7th RULE: Fights will go on as long as they have to.\n8th RULE: If this is your first night at Dots & Boxes, you HAVE to fight.", "Rules" ,JOptionPane.INFORMATION_MESSAGE);
        });
        jMIAbout.addActionListener((event) -> {
          JOptionPane.showMessageDialog(null, "Author: \nBläsi\nSamuel Degelo\nDaniel Föhn\nMartin Etterlin", "About", JOptionPane.INFORMATION_MESSAGE);
        });
    }
    
    //Private method to configure JPanels
    private void confJPanels(){
        //jPanelCenter
        jPanelCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanelCenter.setLayout(new FlowLayout() );
        
        //jPanelWest
        jPanelWest.setLayout(new GridLayout(2,0));
        jPanelWest.setBorder(BorderFactory.createEmptyBorder(20 , 20, 20, 20));
        jPanelWest.add(jPanelScoreView);
        jPanelWest.add(jLabelTurn);
        
        //jLabelTurn
        jLabelTurn.setFont(fontScore);
        jLabelTurn.setForeground(Color.RED);
        
        //jPanelScoreView
        jPanelScoreView.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.anchor = GridBagConstraints.LINE_START;
        jPanelScoreView.add(jLabelScoreOwn,gbc);
        gbc.gridx++;
        jPanelScoreView.add(jLabelScoreOwnPoints,gbc);
        gbc.gridy++;
        gbc.gridx--;
        jPanelScoreView.add(jLabelScoreOpponent, gbc);
        gbc.gridx++;
        jPanelScoreView.add(jLabelScoreOpponentPoints, gbc);
    }
    
    //Private method to configure JLabels
    private void confJLabels(){
        //jLabel
        jLabelScoreOpponent.setForeground(Color.blue);
        jLabelScoreOwn.setForeground(Color.red);
        jLabelScoreOpponentPoints.setForeground(Color.blue);
        jLabelScoreOwnPoints.setForeground(Color.red);
        jLabelScoreOpponent.setFont(fontScore);
        jLabelScoreOpponentPoints.setFont(fontScore);
        jLabelScoreOwn.setFont(fontScore);
        jLabelScoreOwnPoints.setFont(fontScore);
    }
    
    //Private method to configure fileChooser
    private void confJFileChooser(){
        //jFChosser
        jFChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Dots And Box", "fdab", "fdab");
        jFChooser.setFileFilter(filter);
        jFChooser.setSelectedFile(new File("saveGame.fdab"));
    }
    
    
    @Override
    public void startGameView(int width, int height) {
        //Removes map if already exists to initialize a new one
        if(map1 != null)
        {
            jPanelCenter.remove(map1);
        }
        map1= new MapView(width, height);
        //Adding MouseListener which returns Line to observer 
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
    
    //private method to convert GUI/View Line into Business Logic Line
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
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void updatePlayerTurn(boolean isOpponent) {
        if(isOpponent){
            jLabelTurn.setText("Opponent turn!");
            jLabelTurn.setForeground(Color.BLUE);
        }
        else{
            jLabelTurn.setText("Your turn!");
            jLabelTurn.setForeground(Color.RED);
        } 
    }

    @Override
    public void drawSquare(int x1, int y1, boolean isOpponent) {
        map1.drawSquare(x1, y1, isOpponent);
    }
}

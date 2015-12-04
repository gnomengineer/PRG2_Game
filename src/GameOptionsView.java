/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metterlin
 */
import Enums.GameModeEnum;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.*;
import Interfaces.GameOptionsViewInterface;

/**
 *
 * @author metterlin
 */
public class GameOptionsView implements ActionListener, GameOptionsViewInterface {

    private static final Dimension size= new Dimension(400,200);
    JFrame jframeOptions;
    JPanel jPanelOptions;
    JPanel jPanelGameMode;
    JPanel jPanelField;
    JPanel jPanelSubmit;
    JLabel jLabelGameMode;
    JLabel jLabelFieldSize;
    JLabel jLabelx;
    JLabel jLabely;
    ButtonGroup bgrpRadioButtons;
    JRadioButton jRadioSingle;
    JRadioButton jRadioMulti;
    JSlider jSliderX;
    JSlider jSliderY;
    JButton jBtnSubmit; 
    Font font;
    
    
    //Important Game Variables
    private boolean singleplayer;
    private int xSize;
    private int ySize;
    
    
    
    public GameOptionsView(){
        jframeOptions=new JFrame("Options Dots and Boxes");
        jPanelOptions= new JPanel();
        jLabelGameMode = new JLabel("Game Mode");
        jLabelFieldSize= new JLabel("Field Size");
        bgrpRadioButtons = new ButtonGroup();
        jRadioSingle = new JRadioButton("SinglePlayer");
        jRadioMulti= new JRadioButton("MultiPlayer");
        jPanelGameMode = new JPanel();
        jPanelField = new JPanel();
        jSliderX = new JSlider(0, 20, 10);
        jSliderY = new JSlider(0,20,10);
        jBtnSubmit = new  JButton("Submit");
        jPanelSubmit = new JPanel();
        font = new Font("Serif", Font.ITALIC,10);
        
        
                
        setup();
    }
    public void setup(){
        
        //jFrame
        jframeOptions.setSize(size);
        jframeOptions.setPreferredSize(size);
        jframeOptions.add(jPanelOptions);
          
        
        //jPanel Options
        jPanelOptions.setLayout(new BorderLayout());
        jPanelOptions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelOptions.add(jPanelField, BorderLayout.EAST);
        jPanelOptions.add(jPanelGameMode, BorderLayout.CENTER);
        jPanelOptions.add(jPanelSubmit, BorderLayout.SOUTH);
        
        //Setup JPanel Submit
        jPanelSubmit.add(jBtnSubmit);
               
        //Radio Buttons
        jRadioSingle.setSelected(true);
        bgrpRadioButtons.add(jRadioSingle);
        bgrpRadioButtons.add(jRadioMulti);
        
        //jBtnSubmit
        jBtnSubmit.addActionListener(this);
        
        
        //Slider X
        jSliderX.setMajorTickSpacing(5);
        jSliderX.setMinorTickSpacing(1);
        jSliderX.setPaintTicks(true);
        jSliderX.setPaintLabels(true);
        jSliderX.setFont(font);
        jSliderX.setSnapToTicks(true);
        
        //Slider Y
        jSliderY.setMajorTickSpacing(5);
        jSliderY.setMinorTickSpacing(1);
        jSliderY.setPaintTicks(true);
        jSliderY.setPaintLabels(true);
        jSliderY.setFont(font);
        jSliderY.setSnapToTicks(true);
        
        //JPanel GameMode
        jPanelGameMode.setLayout(new GridLayout(3,0));
        jPanelGameMode.add(jLabelGameMode);
        jPanelGameMode.add(jRadioSingle);
        jPanelGameMode.add(jRadioMulti);
         
        //JPanel Field
        jPanelField.setLayout(new GridLayout(3,0));
        jPanelField.add(jLabelFieldSize);
        jPanelField.add(jSliderX);
        jPanelField.add(jSliderY);
             
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        System.out.println(singleplayer);
        System.out.println(xSize);
        System.out.println(ySize);
    }

    @Override
    public void registerOptionActionListener(ActionListener actionListener) {
        jBtnSubmit.addActionListener(actionListener);
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
    public int getFieldWidth() {
        return jSliderX.getValue();
    }

    @Override
    public int getFieldHeight() {
        return jSliderY.getValue();
    }

    @Override
    public GameModeEnum getGameMode() {
        if(jRadioSingle.isSelected()){
            return GameModeEnum.AIMode;
        }
        else {
            return GameModeEnum.MultiplayerMode;
        }
    }

    @Override
    public void startOptionsView() {
        jframeOptions.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metterlin
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.JFrame.*;

/**
 *
 * @author metterlin
 */
public class GameOptionsView {

    JFrame jframeOptions;
    JPanel jPanelOptions;
    JPanel jPanelGameMode;
    JPanel jPanelField;
    JLabel jLabelGameMode;
    JLabel jLabelFieldSize;
    JLabel jLabelx;
    JLabel jLabely;
    ButtonGroup bgrpRadioButtons;
    JRadioButton jRadioSingle;
    JRadioButton jRadioMulti;
    JSlider jSliderX;
    JSlider jSliderY;
    
      
    private static final Dimension size= new Dimension(800,200);
    
    
    
    
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
        
        setup();
    }
    public void setup(){
        jframeOptions.setSize(size);
        jframeOptions.setPreferredSize(size);
        jPanelOptions = new JPanel();
        jframeOptions.add(jPanelOptions);
        jframeOptions.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframeOptions.setVisible(true);
        
        //JSlider
        
        
        //jPanel
        jPanelOptions.setLayout(new GridLayout(1,2));
        
        //Radio Buttons
        bgrpRadioButtons.add(jRadioSingle);
        bgrpRadioButtons.add(jRadioMulti);
        
        //Setup JPanel
        jPanelOptions.add(jPanelGameMode);
        jPanelOptions.add(jPanelField);
        jPanelGameMode.setLayout(new GridLayout(0,1));
        jPanelField.setLayout(new GridLayout(0,1));
        
        //Fill Panells
        jPanelGameMode.add(jRadioSingle);
        jPanelGameMode.add(jRadioMulti);
        
        
        
        
        
        
        
    }
    public static void main(String[] args){
        GameOptionsView optionView1 = new GameOptionsView();
    }
}

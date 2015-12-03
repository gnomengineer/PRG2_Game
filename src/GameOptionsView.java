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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.*;

/**
 *
 * @author metterlin
 */
public class GameOptionsView implements ActionListener {

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
        jframeOptions.setDefaultCloseOperation(EXIT_ON_CLOSE);   
        
        //jPanel Options
        jPanelOptions.setLayout(new BorderLayout());
        jPanelOptions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanelOptions.add(jPanelField, BorderLayout.EAST);
        jPanelOptions.add(jPanelGameMode, BorderLayout.CENTER);
        jPanelOptions.add(jPanelSubmit, BorderLayout.SOUTH);
        
        //Setup JPanel Submit
        jPanelSubmit.add(jBtnSubmit);
               
        //Radio Buttons
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
        
       
        jframeOptions.setVisible(true);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jRadioSingle.isSelected()){
            singleplayer=true;
        }
        else{
            singleplayer=false;
        }
        
        xSize= jSliderX.getValue();
        ySize= jSliderY.getValue();
        System.out.println(singleplayer);
        System.out.println(xSize);
        System.out.println(ySize);
        new GameView();
    }
    
}

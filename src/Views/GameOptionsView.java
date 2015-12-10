package Views;

import Enums.GameModeEnum;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.JFrame.*;
import Interfaces.GameOptionsViewInterface;
import Interfaces.ObserverInterface;
import Interfaces.SubjectInterface;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * GUI for setting options in Dots & Boxes.
 * Informs Controller about settings made. 
 * @author Martin Etterlin
 */
public class GameOptionsView implements GameOptionsViewInterface, SubjectInterface {

    private static final Dimension size= new Dimension(400,200);
    JFrame jFrameOptions;
    JPanel jPanelOptions;
    JPanel jPanelGameMode;
    JPanel jPanelField;
    JPanel jPanelSubmit;
    JLabel jLabelGameMode;
    JLabel jLabelFieldSize;
    JLabel jLabelx;
    JLabel jLabely;
    ButtonGroup bGrpRadioButtons;
    JRadioButton jRadioSingle;
    JRadioButton jRadioMultiClient;
    JRadioButton jRadioMultiServer;
    JSlider jSliderWidth;
    JSlider jSliderHeight;
    JButton jBtnSubmit; 
    JTextField jTxtIpAddress;
    JTextField jTxtPort;
    Font font;
    ObserverInterface observer;
    
    public GameOptionsView(){
        jFrameOptions=new JFrame("Options Dots and Boxes");
        jPanelOptions= new JPanel();
        jLabelGameMode = new JLabel("Game Mode");
        jLabelFieldSize= new JLabel("Field Size");
        bGrpRadioButtons = new ButtonGroup();
        jRadioSingle = new JRadioButton("SinglePlayer");
        jRadioMultiClient= new JRadioButton("MultiPlayer Client");
        jRadioMultiServer = new JRadioButton("Multiplayer Server");
        jPanelGameMode = new JPanel();
        jPanelField = new JPanel();
        jSliderWidth = new JSlider(0, 20, 10);
        jSliderHeight = new JSlider(0,20,10);
        jBtnSubmit = new  JButton("Submit");
        jPanelSubmit = new JPanel();
        jTxtIpAddress= new JTextField("IP Address");
        jTxtPort = new JTextField("Port");
        font = new Font("Serif", Font.ITALIC,10);
     
        setup();
    }
    /**
     * Sets up GUI Components
     */
    private void setup(){
        //jButton
        jBtnSubmit.addActionListener(event ->
        { 
            observer.submitOptions();
        });
        
        //jFrame
        jFrameOptions.setSize(size);
        jFrameOptions.setPreferredSize(size);
        jFrameOptions.add(jPanelOptions);
        jFrameOptions.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        jRadioMultiServer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(jRadioMultiServer.isSelected()){
                    jTxtIpAddress.setEditable(true); 
                    jTxtPort.setEditable(true);
                }
                else{
                    jTxtIpAddress.setEditable(false);
                    jTxtPort.setEditable(false);
                }
            }
        });
        
        //Radio Buttons Group
        bGrpRadioButtons.add(jRadioSingle);
        bGrpRadioButtons.add(jRadioMultiClient);
        bGrpRadioButtons.add(jRadioMultiServer);
        
        //TxtFields
        jTxtIpAddress.setEditable(false);
        jTxtPort.setEditable(false);
        
        //Slider X
        jSliderWidth.setMajorTickSpacing(5);
        jSliderWidth.setMinorTickSpacing(1);
        jSliderWidth.setPaintTicks(true);
        jSliderWidth.setPaintLabels(true);
        jSliderWidth.setFont(font);
        jSliderWidth.setSnapToTicks(true);
        
        //Slider Y
        jSliderHeight.setMajorTickSpacing(5);
        jSliderHeight.setMinorTickSpacing(1);
        jSliderHeight.setPaintTicks(true);
        jSliderHeight.setPaintLabels(true);
        jSliderHeight.setFont(font);
        jSliderHeight.setSnapToTicks(true);
        
        //JPanel GameMode
        jPanelGameMode.setLayout(new GridLayout(0,1));
        jPanelGameMode.add(jLabelGameMode);
        jPanelGameMode.add(jRadioSingle);
        jPanelGameMode.add(jRadioMultiClient);
        jPanelGameMode.add(jRadioMultiServer);
        jPanelGameMode.add(jTxtIpAddress);
        jPanelGameMode.add(jTxtPort);
         
        //JPanel Field
        jPanelField.setLayout(new GridLayout(3,0));
        jPanelField.add(jLabelFieldSize);
        jPanelField.add(jSliderWidth);
        jPanelField.add(jSliderHeight);
    }

    @Override
    public String getIPAddress() {
        return jTxtIpAddress.getText();
    }

    @Override
    public String getPortNumber() {
        return jTxtPort.getText();
    }

    @Override
    public int getFieldWidth() {
        return jSliderWidth.getValue();
    }

    @Override
    public int getFieldHeight() {
        return jSliderHeight.getValue();
    }

    @Override
    public GameModeEnum getGameMode() {
        if(jRadioSingle.isSelected()){
            return GameModeEnum.AIMode;
        }
        else if(jRadioMultiServer.isSelected()){
            return GameModeEnum.MultiplayerServerMode;
        }
        else {
            return GameModeEnum.MultiplayerClientMode;
        }
    }

    @Override
    public void startOptionsView() {
        jFrameOptions.setVisible(true);
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        // nothing todo
    }
    
}

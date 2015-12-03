/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metterlin
 */
import javax.swing.*;

/**
 *
 * @author metterlin
 */
public class GameOptionsView {

    JFrame jframeOptions;
    JPanel jPanelOptions;
    private int width=100;
    private int height= 50;
    
    
    
    public GameOptionsView(){
        jframeOptions=new JFrame("Options Dots and Boxes");
        setup();
    }
    public void setup(){
        jframeOptions.setSize(width, height);
        jPanelOptions = new JPanel();
        jframeOptions.add(jPanelOptions);
        jframeOptions.setVisible(true);
        jframeOptions.
        
        
    }
    public static void main(String[] args){
        GameOptionsView optionView1 = new GameOptionsView();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.geom.Line2D;
/**
 *
 * @author Martin
 */
public class MapView extends JPanel {
    private int angle = 0;
   
    public MapView(){
        setBackground(Color.red);
        add(new JButton("test"));
        
        
    }
    
    public void setVisible(){
        setVisible(true);
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.draw(new Line2D.Double(30, 30, 30, 60));


    }
}

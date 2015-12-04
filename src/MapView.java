/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.*;
/**
 *
 * @author Martin
 */
public class MapView extends JPanel {
     private int angle = 0;
    private Rectangle shape = new Rectangle(0, 0, 100, 100);
    public MapView(){
        setBackground(Color.red);
        setSize(new Dimension(100,100));
        
        add(new JButton("test"));
        
        
    }
    
    public void setVisible(){
        setVisible(true);
    }/*
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int x = ((getWidth() - shape.width) / 2);
            int y = ((getHeight() - shape.height) / 2);

            shape.x = x;
            shape.y = y;

            g2d.setColor(Color.BLUE);
            g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(angle), x + (shape.width / 2), y + (shape.height / 2)));
            g2d.fill(shape);

            g2d.dispose();
        }*/

    
        
}

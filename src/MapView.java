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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author Martin
 */
public class MapView extends JPanel {
    private int angle = 0;
    private int mWidth;
    private int mHeight;
    Graphics2D g2d;
    Rectangle2D.Double[][] points;
   
    public MapView(int mWidth, int mHeight){
        //setBackground(Color.red);
        add(new JButton("test"));
        this.mWidth = mWidth;
        this.mHeight= mHeight;
        
    }
    
    public void setVisible(){
        setVisible(true);
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g.create();
        initPoints();
        drawPoints();
    }
    private void initPoints(){
        int ycoordinates=10;
        int xcoordinates=10;
        points= new Rectangle2D.Double[mWidth+1][mHeight+1];
        for(int i=0; i<=mHeight;i++){
            for(int y=0; y<=mWidth; y++){
                points[i][y]= new Rectangle2D.Double(xcoordinates-0.5, ycoordinates-0.5, 0.5, 0.5);
                xcoordinates=xcoordinates+30;
            }
            xcoordinates=10;
            ycoordinates =ycoordinates+30;
        }
        
    }
    
    private void drawPoints(){
        for(int i=0; i<=mHeight;i++){
            for(int y=0; y<=mWidth; y++){
                g2d.draw(points[i][y]);
            }
        }
    }
}

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
    private int space=30;
   
    Graphics2D g2d;
    SquareView[][] squareviews;
   
    /**
     * Create MapView with specified size
     * @param mWidth
     * @param mHeight 
     */
    public MapView(int mWidth, int mHeight){
        this.mWidth = mWidth;
        this.mHeight= mHeight;
        this.squareviews = new SquareView[mHeight][mWidth];
        setPreferredSize(new Dimension(mHeight*space, mWidth*space));
        
    }
    
    public void generateField(){
        for(int i = 0; i < mWidth; i++)
        {
            for(int y = 0; y < mHeight; y++)
            {
                
                Point2D.Double pTopLeft = new Point2D.Double(i*10,y*10);
                Point2D.Double pTopRight = new Point2D.Double(i*10,(y+1)*10);
                Point2D.Double pBotLeft = new Point2D.Double((i+1)*10,y*10);
                Point2D.Double pBotRight = new Point2D.Double((i+1)*10,(y+1)*10);                
                SquareView s = new SquareView();
                if(i == 0)
                {
                    s.setLineTop(new Line2D.Double(pTopLeft,pTopRight));
                }
                else
                {
                    s.setLineTop((squareviews[i-1][y]).getLineBot());
                }
                if(y == 0)
                {
                    s.setLineLeft(new Line2D.Double(pTopLeft,pBotLeft));
                }
                else
                {
                    s.setLineLeft(squareviews[i][y-1].getLineRight());
                }
                s.setLineRight(new Line2D.Double(pTopRight,pBotRight));
                s.setLineBot(new Line2D.Double(pBotLeft,pBotRight));
                squareviews[i][y] = s;
            }
        }
    }
        

    
    public void drawField(){
        for(SquareView squarex[] : squareviews){
            for(SquareView square : squarex){
                g2d.draw(square.getLineBot());
                g2d.draw(square.getLineLeft());
                g2d.draw(square.getLineRight());
                g2d.draw(square.getLineTop());
            }
        }
        
    }
    
    

     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g.create();
        generateField();
        drawField();
    }
    
    /**
     * Initialising all Points and save it into an Array
     */
  
    
}

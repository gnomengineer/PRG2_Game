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
    Rectangle2D.Double[][] points;
   
    /**
     * Create MapView with specified size
     * @param mWidth
     * @param mHeight 
     */
    public MapView(int mWidth, int mHeight){
        this.mWidth = mWidth;
        this.mHeight= mHeight;
        setPreferredSize(new Dimension(mHeight*space, mWidth*space));
        
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
    
    /**
     * Initialising all Points and save it into an Array
     */
    private void initPoints(){
        int ycoordinates=0;
        int xcoordinates=0;
        points= new Rectangle2D.Double[mWidth+1][mHeight+1];
        for(int i=0; i<=mHeight;i++){
            for(int y=0; y<=mWidth; y++){
                points[i][y]= new Rectangle2D.Double(xcoordinates, ycoordinates, 2, 2);
                xcoordinates=xcoordinates+space;
            }
            xcoordinates=0;
            ycoordinates =ycoordinates+space;
        } 
        
    }
    
    /**
     * Draw Points
     */
    private void drawPoints(){
        for(int i=0; i<=mHeight;i++){
            for(int y=0; y<=mWidth; y++){
                g2d.draw(points[i][y]);
            }
        }
        
    }
    
    public GameObjects.Point translateCoordinates(GameObjects.Point point){
        int pointx = point.getX();
        int pointy = point.getY();
        int coordinatesx = pointx *30;
        return null;
    }
    
    public void drawLine(GameObjects.Line line){
        
    }
    
}

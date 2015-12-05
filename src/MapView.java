/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GameObjects.Line;
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
    private int space=40;
    Rectangle2D.Double[][] points;
   
    Graphics2D lingraphics;
    Graphics2D pointgraphics;
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
        setPreferredSize(new Dimension(mHeight*space+5, mWidth*space+5));
    }
    
         @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        lingraphics = (Graphics2D) g.create();
        pointgraphics =(Graphics2D) g.create();
        generateField();
        drawField();
        initPoints();
        drawPoints();
    }
    
    
    public void drawLine(Line line){
        
        Line2D.Double line2d = new Line2D.Double(line.getStartPoint().getX(), line.getStartPoint().getY(), line.getEndPoint().getX(), line.getEndPoint().getY());
        //getline(line2d);
        
    }
    /*
    public void getline(Line2D.Double line){
        for(int i=0; i<squareviews.length; i++)
        {
            for(int y=0; y<squareviews.length; i++){
                SquareView square= squareviews[i][y];
                
               if((square.getLineTop().getX1() == line.getX1()) && (square.getLineTop().getY1() == line.getY1())){
                   
               }
            
            }
        }
    }
    */
    
    public void generateField(){
        for(int i = 0; i < mWidth; i++)
        {
            for(int y = 0; y < mHeight; y++)
            {
                
                Point2D.Double pTopLeft = new Point2D.Double(i*space,y*space);
                Point2D.Double pTopRight = new Point2D.Double(i*space,(y+1)*space);
                Point2D.Double pBotLeft = new Point2D.Double((i+1)*space,y*space);
                Point2D.Double pBotRight = new Point2D.Double((i+1)*space,(y+1)*space);                
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
                lingraphics.draw(square.getLineBot());
                lingraphics.draw(square.getLineLeft());
                lingraphics.draw(square.getLineRight());
                lingraphics.draw(square.getLineTop());
            }
        }
    }
    
    private void initPoints(){
        int ycoordinates=0;
        int xcoordinates=0;
        points= new Rectangle2D.Double[mWidth+1][mHeight+1];
        for(int i=0; i<=mHeight;i++){
            for(int y=0; y<=mWidth; y++){
                points[i][y]= new Rectangle2D.Double(xcoordinates-2, ycoordinates-2, 4, 4);
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
                pointgraphics.draw(points[i][y]);
                pointgraphics.fill(points[i][y]);
            }
        }
        
    }
}

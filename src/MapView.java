/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import GameObjects.Line;
import java.awt.*;
import java.awt.event.*;
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
   
    Graphics2D graphicsOpponent;
    Graphics2D graphicsPlayer;
    Graphics2D graphicsPoints;
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
        
        setup();
        
    }
    
    public void setup(){
        setPreferredSize(new Dimension(mHeight*space+5, mWidth*space+5));
        
        //Create Mouselistener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                System.out.println(e.getPoint());
            }
        });
    }
         @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphicsOpponent = (Graphics2D) g.create();
        graphicsPlayer = (Graphics2D) g.create();
        graphicsPoints =(Graphics2D) g.create();
        graphicsPlayer.setColor(Color.red);
        graphicsOpponent.setColor(Color.blue);
        generateField();
        //drawField();
        drawLine(new Line(1, 1, 1, 2), true);
        drawLine(new Line(1, 1, 2, 1), false);
        drawLine(new Line(8,8,9,8),true);
        initPoints();
        drawPoints();
    }
    
    
    public void drawLine(Line line, Boolean isOpponent){
        
        LineView line2d = new LineView(line.getStartPoint().getX()*space, line.getStartPoint().getY()*space, line.getEndPoint().getX()*space, line.getEndPoint().getY()*space);
        for(int i=0; i<squareviews.length; i++)
        {
            for(int y=0; y<squareviews.length; y++){
                SquareView square= squareviews[i][y];
                
               if(square.getLineTop().equals(line2d)){
                   if(isOpponent){
                       graphicsOpponent.draw(square.getLineTop());
                   }
                   else{
                       graphicsPlayer.draw(square.getLineTop());
                   }
               }
               else if(square.getLineRight().equals(line2d)){
                   if(isOpponent){
                       graphicsOpponent.draw(square.getLineRight());
                   }
                   else{
                       graphicsPlayer.draw(square.getLineRight());
                   }
               }
               else if(square.getLineBot().equals(line2d)){
                   if(isOpponent){
                       graphicsOpponent.draw(square.getLineBot());
                   }
                   else{
                       graphicsPlayer.draw(square.getLineBot());
                   }
               }
               else if(square.getLineLeft().equals(line2d)){
                   if(isOpponent){
                       graphicsOpponent.draw(square.getLineLeft());
                   }
                   else{
                       graphicsPlayer.draw(square.getLineLeft());
                   }
                   
               }
            }
        }
    }
    
 
    
    
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
                    s.setLineTop(new LineView(pTopLeft,pTopRight));
                }
                else
                {
                    s.setLineTop((squareviews[i-1][y]).getLineBot());
                }
                if(y == 0)
                {
                    s.setLineLeft(new LineView(pTopLeft,pBotLeft));
                }
                else
                {
                    s.setLineLeft(squareviews[i][y-1].getLineRight());
                }
                s.setLineRight(new LineView(pTopRight,pBotRight));
                s.setLineBot(new LineView(pBotLeft,pBotRight));
                squareviews[i][y] = s;
            }
        }
    }
/*
    public void drawField(){
        for(SquareView squarex[] : squareviews){
            for(SquareView square : squarex){
                graphicsOpponent.draw(square.getLineBot());
                graphicsOpponent.draw(square.getLineLeft());
                graphicsOpponent.draw(square.getLineRight());
                graphicsOpponent.draw(square.getLineTop());
            }
        }
    }
*/
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
                graphicsPoints.draw(points[i][y]);
                graphicsPoints.fill(points[i][y]);
            }
        }
        
    }
}

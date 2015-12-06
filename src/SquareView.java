
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class SquareView {
    
    private SquareAoIView aoiLeft;
    private SquareAoIView aoiRight;
    private SquareAoIView aoiTop;
    private SquareAoIView aoiBot;
    LineView lineTop;
    LineView lineBot;
    LineView lineLeft;
    LineView lineRight;

    public void getCorrespondingLine(){
        
    }
    
    public LineView getLineTop() {
        return lineTop;
    }

    public LineView getLineBot() {
        return lineBot;
    }

    public LineView getLineLeft() {
        return lineLeft;
    }

    public LineView getLineRight() {
        return lineRight;
    }

    public void setLineBot(LineView lineBot) {
        this.lineBot = lineBot;
        Point2D.Double p1 = (Point2D.Double)lineBot.getP1();
        Point2D.Double p2 = (Point2D.Double)lineBot.getP2();
        Point2D.Double p3= new Point2D.Double(lineBot.getX1() + (MapView.getSpace() /2), lineBot.getY1() - (MapView.getSpace()/2));
        aoiBot=new SquareAoIView(p1, p2, p3);
    }

    public void setLineLeft(LineView lineLeft) {
        this.lineLeft = lineLeft;
        Point2D.Double p1 = (Point2D.Double)lineLeft.getP1();
        Point2D.Double p2 = (Point2D.Double)lineLeft.getP2();
        Point2D.Double p3= new Point2D.Double(lineLeft.getX1() + (MapView.getSpace() /2), lineLeft.getY1() + (MapView.getSpace()/2));
        aoiLeft=new SquareAoIView(p1, p2, p3);
    }

    public void setLineRight(LineView lineRight) {
        this.lineRight = lineRight;
        Point2D.Double p1 = (Point2D.Double)lineRight.getP1();
        Point2D.Double p2 = (Point2D.Double)lineRight.getP2();
        Point2D.Double p3= new Point2D.Double(lineRight.getX1() - (MapView.getSpace() /2), lineRight.getY1() + (MapView.getSpace()/2));
        aoiRight=new SquareAoIView(p1, p2, p3);
        
    }

    public void setLineTop(LineView lineTop) {
        this.lineTop = lineTop;
        Point2D.Double p1 = (Point2D.Double)lineTop.getP1();
        Point2D.Double p2 = (Point2D.Double)lineTop.getP2();
        Point2D.Double p3= new Point2D.Double(lineTop.getX1() + (MapView.getSpace() /2), lineTop.getY1() + (MapView.getSpace()/2));
        aoiTop=new SquareAoIView(p1, p2, p3);
    }
    
    public void SquareView(){
        lineTop=null;
        lineLeft=null;
        lineBot=null;
        lineRight=null;
        
    }
    
    public LineView getLine(Point2D.Double point){
        
          if(pointInTriangle(point, aoiTop.getP1(), aoiTop.getP2(), aoiTop.getP3())){
              return lineTop;
          }
          else if(pointInTriangle(point, aoiBot.getP1(), aoiBot.getP2(), aoiBot.getP3())){
              return lineBot;
          }
          else if(pointInTriangle(point, aoiLeft.getP1(), aoiLeft.getP2(), aoiLeft.getP3())){
              return lineLeft;
          }
          else{
              return lineRight;
          }
          
    }
        
     public boolean contains(Point2D.Double point){
        if((point.getX() > lineTop.getX1()) && (point.getY() < lineBot.getY2())){
            System.out.println("Linetop X: "+lineTop.getX1());
            System.out.println("Linetop Y: " + lineTop.getY1());
            System.out.println("Linebot X: " + lineBot.getX2());
            System.out.println("Linebot Y: " + lineBot.getY2());
            return true;
        }
        else{
            return false;
        }
    }
    
    
     
     private boolean pointInTriangle (Point2D.Double p, Point2D.Double p1, Point2D.Double p2, Point2D.Double p3)
    {
        boolean b1, b2, b3;

        double alpha = ((p2.y - p3.y)*(p.x - p3.x) + (p3.x - p2.x)*(p.y - p3.y)) /
        ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x - p2.x)*(p1.y - p3.y));
        double beta = ((p3.y - p1.y)*(p.x - p3.x) + (p1.x - p3.x)*(p.y - p3.y)) /
       ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x - p2.x)*(p1.y - p3.y));
        double gamma = 1.0f - alpha - beta;

        if(alpha>0 && beta >0 && gamma>0){
        return true;
        }
        return false;
    }
    /*
    private double sign (Point2D.Double p1, Point2D.Double p2, Point2D.Double p3)
    {
        return (p1.y - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    private boolean pointInTriangle (Point2D.Double pt, Point2D.Double v1, Point2D.Double v2, Point2D.Double v3)
    {
        boolean b1, b2, b3;

        b1 = sign(pt, v1, v2) < 0.0d;
        b2 = sign(pt, v2, v3) < 0.0d;
        b3 = sign(pt, v3, v1) < 0.0d;

        return ((b1 == b2) && (b2 == b3));
    }
    
    */
    
    
   
 

    
    public void fill(){
        
                
    }
    
            
    
}

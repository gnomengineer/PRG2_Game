package Views;


import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A Square Object does have 4 Lines and for each Line a AOI(Area of Interest).
 * @author Martin Etterlin
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
    
    public void SquareView(){
        lineTop=null;
        lineLeft=null;
        lineBot=null;
        lineRight=null;
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
    
    /**
     * Returns the line associated to the point
     * @param point
     * @return 
     */
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
    
    /**
     * Return true if specified Point is inside this square.
     * @param point
     * @return 
     */
    public boolean contains(Point2D.Double point){
         double pointX = point.getX();
         double pointY = point.getY();
         double lineTopX1 = lineTop.getX1();
         double lineTopX2 = lineTop.getX2();
         double lineLeftY1 = lineLeft.getY1();
         double lineLeftY2 = lineLeft.getY2();
                 
        if( ( (pointX > lineTopX1) && (pointX < lineTopX2) ) && ((pointY > lineLeftY1) && (pointY < lineLeftY2)))  {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Returns true if p is inside the triangle p1, p2, p3
     * @param p point to check
     * @param p1 point 1 of triangle
     * @param p2 point 2 of triangle
     * @param p3 point 3 of triangle
     * @return 
     */ 
    private boolean pointInTriangle (Point2D.Double p, Point2D.Double p1, Point2D.Double p2, Point2D.Double p3){
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
}

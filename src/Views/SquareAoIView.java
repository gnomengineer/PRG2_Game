package Views;


import GameObjects.Point;
import java.awt.geom.Point2D;


/**
 * Does describe the Area of Interest for a Line. Each square does have 4 AOI,and each AOI does lead to one Line. 
 * @author Martin Etterlin
 */
public class SquareAoIView {
    
    Point2D.Double p1;
    Point2D.Double p2;
    Point2D.Double p3;
    
    public SquareAoIView(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point2D.Double getP1() {
        return p1;
    }

    public Point2D.Double getP2() {
        return p2;
    }

    public Point2D.Double getP3() {
        return p3;
    }
}

package Views;


import GameObjects.Point;
import java.awt.geom.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
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
    
    public void doesContainPoint(Point point){
        
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

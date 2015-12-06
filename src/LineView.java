
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin
 */
public class LineView extends Line2D.Double{
    


    public LineView() {
    }

    public LineView(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public LineView(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineView other = (LineView) obj;
        
        if (this.x1 != other.x1) {
            return false;
        }
        if (this.x2 != other.x2) {
            return false;
        }
        if (this.y1 != other.y1) {
            return false;
        }
        if (this.y2 != other.y2) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return "Line X1: " + x1 + "\n" + "Y1: " + y1 + "\nX2: " + x2 +"\nY2: " +y2;
    }
}


import java.awt.geom.Line2D;
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
    
    
    Line2D.Double lineTop;
    Line2D.Double lineBot;
    Line2D.Double lineLeft;
    Line2D.Double lineRight;

    public Line2D.Double getLineTop() {
        return lineTop;
    }

    public Line2D.Double getLineBot() {
        return lineBot;
    }

    public Line2D.Double getLineLeft() {
        return lineLeft;
    }

    public Line2D.Double getLineRight() {
        return lineRight;
    }

    public void setLineBot(Line2D.Double lineBot) {
        this.lineBot = lineBot;
    }

    public void setLineLeft(Line2D.Double lineLeft) {
        this.lineLeft = lineLeft;
    }

    public void setLineRight(Line2D.Double lineRight) {
        this.lineRight = lineRight;
    }

    public void setLineTop(Line2D.Double lineTop) {
        this.lineTop = lineTop;
    }
    
    public void SquareView(){
        lineTop=null;
        lineLeft=null;
        lineBot=null;
        lineRight=null;
    }
 
    

    
    public void fill(){
        
                
    }
    
            
    
}

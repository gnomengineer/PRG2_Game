
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
    
    
    LineView lineTop;
    LineView lineBot;
    LineView lineLeft;
    LineView lineRight;

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
    }

    public void setLineLeft(LineView lineLeft) {
        this.lineLeft = lineLeft;
    }

    public void setLineRight(LineView lineRight) {
        this.lineRight = lineRight;
    }

    public void setLineTop(LineView lineTop) {
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

package GameObjects;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Map 
{
    private Square[][] squares;
    private final int columns;
    private final int rows;
    
    public Map(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.squares = new Square[rows][columns];
        this.generateMap();
    }

    private void generateMap()
    {
        boolean top = true;
        boolean left = true;        
       
        Line topLine;
        Line leftLine;
        Line botLine;
        Line rightLine;
                       
        for(int x = 0; x<rows;x++)
        {
            left = true;
            for(int y = 0; y<columns;y++)
            {
                Point pTopLeft = new Point(x,y);
                Point pTopRight = new Point(x,y+1);
                Point pBotLeft = new Point(x+1,y);
                Point pBotRight = new Point(x,y+1);
                
                Square s = new Square();                
                
                if(top)
                {
                    topLine = new Line(pTopLeft,pTopRight);
                    top = false;
                }
                else
                {
                    topLine = squares[x-1][y].getBotLine();
                }
                if(left)
                {
                    leftLine = new Line(pTopLeft,pBotLeft);
                    left = false;
                }
                else
                {
                    leftLine = squares[x][y-1].getRightLine();
                }
                rightLine = new Line(pTopRight,pBotRight);
                botLine = new Line(pBotLeft,pBotRight);
                
                s.setTopLine(topLine);
                s.setLeftLine(leftLine);
                s.setRightLine(rightLine);
                s.setBotLine(botLine);
            }
        }
    }

    public Line getLine(Point startPoint, Point endPoint) {
        ArrayList<Line> lines = new ArrayList<Line>();
        Square square = null;
        Line returnLine = null;
        
        for (int x = 0; x < this.squares.length; x++) {
            for (int y = 0; y < this.squares.length; y++) {
               
                square = this.squares[x][y];
                
                if(!lines.contains(square.getBotLine()))
                {
                    lines.add(square.getBotLine());
                }
                
                if(!lines.contains(square.getLeftLine()))
                {
                    lines.add(square.getLeftLine());
                }
                  
                if(!lines.contains(square.getRightLine()))
                {
                    lines.add(square.getRightLine());
                }
                    
                if(!lines.contains(square.getTopLine()))
                {
                    lines.add(square.getTopLine());
                }
            }
        }
        
        //line = lines.stream().filter(f => f.)
        
        return null;
    }
}

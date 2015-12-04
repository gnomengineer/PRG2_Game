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
        for(int x = 0; x < rows; x++)
        {
            for(int y = 0; y < columns; y++)
            {
                Point pTopLeft = new Point(x,y);
                Point pTopRight = new Point(x,y+1);
                Point pBotLeft = new Point(x+1,y);
                Point pBotRight = new Point(x+1,y+1);                
                Square s = new Square();
                if(x == 0)
                {
                    s.setTopLine(new Line(pTopLeft,pTopRight));
                }
                else
                {
                    s.setTopLine(squares[x-1][y].getBotLine());
                }
                if(y == 0)
                {
                    s.setLeftLine(new Line(pTopLeft,pBotLeft));
                }
                else
                {
                    s.setLeftLine(squares[x][y-1].getRightLine());
                }
                s.setRightLine(new Line(pTopRight,pBotRight));
                s.setBotLine(new Line(pBotLeft,pBotRight));
                squares[x][y] = s;
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

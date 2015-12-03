package GameObjects;

import java.awt.List;

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
                Point pBotRight = new Point(x+1,y+1);
                
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
}

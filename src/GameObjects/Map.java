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
        squares = new Square[rows][columns];
        this.generateMap();
    }

    private void generateMap()
    {
        boolean top = true;
        boolean left = true;
        boolean bottom = false;        
        boolean right = false;
       
        Line leftLine;
        Line botLine;
        Line rightLine;
               
        for(int x = 0; x<rows;x++)
        {
            
            for(int y = 0; y<columns;y++)
            {
                Square square = new Square();
            }
        }
    }
}

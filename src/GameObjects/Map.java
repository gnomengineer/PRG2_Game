package GameObjects;

import java.awt.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author Andre
 */
public class Map 
{
    private Square[][] squares;
    private final int columns;
    private final int rows;
    private ArrayList<Line> uniquelines;
    private ArrayList<Square> uniqueSquares;
    
    public Map(int rows, int columns)
    {
        this.uniquelines = new ArrayList<Line>();
        this.uniqueSquares = new ArrayList<Square>();
        
        this.rows = rows;
        this.columns = columns;
        this.squares = new Square[columns][rows];
        this.generateMap();
        
        //damit man einfacher nach bestimmen Lines suchen kann
        prepareUniques();
        
    }

    private void generateMap()
    {                              
        for(int x = 0; x < columns; x++)
        {
            for(int y = 0; y < rows; y++)
            {
                Point pTopLeft = new Point(x,y);
                Point pTopRight = new Point((x+1),y);
                Point pBotLeft = new Point(x,(y+1));
                Point pBotRight = new Point((x+1),(y+1));               
                Square s = new Square();
                if(x == 0)
                {
                    s.setLeftLine(new Line(pTopLeft,pBotLeft));
                }
                else
                {
                    s.setLeftLine(squares[x-1][y].getRightLine());
                }
                if(y == 0)
                {
                    s.setTopLine(new Line(pTopLeft,pTopRight));
                }
                else
                {
                    s.setTopLine(squares[x][y-1].getBotLine());
                }
                s.setBotLine(new Line(pBotLeft,pBotRight));
                s.setRightLine(new Line(pTopRight,pBotRight));
                squares[x][y] = s;
            }
        }
    }
    
    private void prepareUniques(){
        Square square = null;

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {
               
                square = this.squares[x][y];
                this.uniqueSquares.add(square);
                
                if(!uniquelines.contains(square.getBotLine()))
                {
                    uniquelines.add(square.getBotLine());
                }
                
                if(!uniquelines.contains(square.getLeftLine()))
                {
                    uniquelines.add(square.getLeftLine());
                }
                  
                if(!uniquelines.contains(square.getRightLine()))
                {
                    uniquelines.add(square.getRightLine());
                }
                    
                if(!uniquelines.contains(square.getTopLine()))
                {
                    uniquelines.add(square.getTopLine());
                }
            }
        }
    }
    
    public int getWidth()
    {
        return this.columns;
    }
    
    public int getHeight()
    {
        return this.rows;
    }
    
    public Square[][] getSquares()
    {
        return this.squares;
    }

    public Line getLine(Point startPoint, Point endPoint) {
        Line resultLine = null;
        Line preparedLine = new Line(startPoint, endPoint);
        
        try{
            
            resultLine = uniquelines.stream().filter((line) -> line.equals(preparedLine)).findFirst().get();
        }
        catch(Exception e)
        {
            // expermiental
        }
        
        return resultLine;
    }
    
    /**
     * Liefert Squares anhand line
     * @param line
     * @return
     */
    public ArrayList<Square> getSquaresBy(Line line)
    {
       ArrayList<Square> filterSquare = new ArrayList<Square>();
        
        this.uniqueSquares.stream().filter((square) -> line.equals(square.getBotLine()) || 
                line.equals(square.getLeftLine()) || 
                line.equals(square.getRightLine()) || 
                line.equals(square.getTopLine())).forEach((s) -> {
            filterSquare.add(s); 
        });
       
       return filterSquare;
    }

    public ArrayList<Line> getLines() {
        return this.uniquelines;
    }
}

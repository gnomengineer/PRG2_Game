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
        this.squares = new Square[rows][columns];
        this.generateMap();
        
        //damit man einfacher nach bestimmen Lines suchen kann
        prepareUniques();
        
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
    
    private void prepareUniques(){
        Square square = null;

        for (int x = 0; x < this.squares.length; x++) {
            for (int y = 0; y < this.squares.length; y++) {
               
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

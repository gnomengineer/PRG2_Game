package GameObjects;

/**
 *
 * @author Andre
 */
public class Line 
{
    private Point startPoint;
    private Point endPoint;
    private Figur owner;
    
    public Line(Point startPoint,Point endPoint)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    public Line(int xStart, int yStart, int xEnd, int yEnd)
    {
        this.startPoint = new Point(xStart,yStart);
        this.endPoint = new Point(xEnd,yEnd);
    }
    
    public Point getStartPoint()
    {
        return startPoint;
    }
    
    public Point getEndPoint()
    {
        return endPoint;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }       
        
        if(obj == null)
        {
            return false;
        }
        
        if(obj.getClass() != this.getClass())
        {
            return false;
        }
                
        if(this.startPoint != ((Line)obj).getStartPoint() || this.endPoint != ((Line)obj).getEndPoint())
        {
            return false;
        }
        return true;
    }
}

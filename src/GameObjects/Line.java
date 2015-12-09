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
        return this.startPoint;
    }
    
    public Point getEndPoint()
    {
        return this.endPoint;
    }
    
    public void setOwner(Figur figur)
    {
        this.owner = figur;
    }
    
    public Figur getOwner()
    {
        return this.owner;
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
         
        // we: ich habe das gefühl, da muss man mit equals suchen, so dass 2 point instanzen gleich sind, solange x und y dem so ist!!
        //if(this.startPoint != ((Line)obj).getStartPoint() || this.endPoint != ((Line)obj).getEndPoint())
        //{
         //   return false;
        //}
        
        if(!this.startPoint.equals(((Line)obj).getStartPoint()) || !this.endPoint.equals(((Line)obj).getEndPoint()))
        {
            return false;
        }
        
        return true;
    }

    public  boolean isOwned() {
        return this.owner != null;
    }
}

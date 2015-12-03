package GameObjects;

/**
 *
 * @author Andre
 */
public class Square 
{
    private Line topLine;
    private Line botLine;
    private Line leftLine;
    private Line rightLine;
    
    public Square()
    {
        
    }
    
    public void setTopLine(Line line)    
    {
        this.topLine = line;
    }
    
    public Line getTopLine()
    {
        return this.topLine;
    }
    
    public void setBotLine(Line line)
    {
        this.botLine = line;
    }
    
    public Line getBotLine()
    {
        return this.botLine;
    }
    
    public void setLeftLine(Line line)
    {
        this.leftLine = line;
    }
    
    public Line getLeftLine()
    {
        return this.leftLine;
    }
    
    public void setRightLine(Line line)
    {
        this.rightLine = line;
    }
    
    public Line getRightLine()
    {
        return this.rightLine;
    }
}

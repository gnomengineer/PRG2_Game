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
    
    public void setBotLine(Line line)
    {
        this.botLine = line;
    }
    
    public void setLeftLine(Line line)
    {
        this.leftLine = line;
    }
    
    public void setRigthLine(Line line)
    {
        this.rightLine = line;
    }
}

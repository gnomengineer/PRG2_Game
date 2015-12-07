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
    private Figur owner;
    
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
    
    public boolean setOwnerRight(Figur figur)
    {
        this.rightLine.setOwner(figur);
        if(isComplete())
        {
            this.owner = figur;
            return true;
        }
        return false;
    }
    
    public boolean setOwnerLeft(Figur figur)
    {
        this.leftLine.setOwner(figur);
        if(isComplete())
        {
            this.owner = figur;
            return true;
        }
        return false;
    }
    
    public boolean setOwnerTop(Figur figur)
    {
        this.topLine.setOwner(figur);
        if(isComplete())
        {
            this.owner = figur;
            return true;
        }
        return false;
    }
    
    public boolean setOwnerBottom(Figur figur)
    {
        this.botLine.setOwner(figur);
        if(isComplete())
        {
            this.owner = figur;
            return true;
        }
        return false;
    }
    
    public Figur getOwner()
    {
        return this.owner;
    }

    private boolean isComplete()
    {
        return leftLine.getOwner() != null && topLine.getOwner() != null && rightLine.getOwner() != null && botLine.getOwner() != null;
    }

    public void setOwner(Figur owner) {
        this.owner = owner;
    }
    
    public boolean isOwned()
    {
        return this.owner != null;
    }

    public boolean isTaken() {
        if(this.leftLine.isOwned() && this.rightLine.isOwned() && this.topLine.isOwned() && this.botLine.isOwned())
        {
            return true;
        }
        
        return false;
    }
}

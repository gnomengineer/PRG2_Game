package GameObjects;


/**
 *
 * @author Andre
 */
public class Figur {
    private int points;
    private final boolean isOpponent;
    
    public Figur(boolean isOpponent)
    {
        this.isOpponent = isOpponent;
    }
    
    public void incresePoints(int points)
    {
        this.points += points;        
    }    
    
    public void resetPoints(){
        this.points = 0;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public boolean isOpponent()
    {
        return this.isOpponent;
    }
}

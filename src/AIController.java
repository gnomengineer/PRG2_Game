import GameObjects.Line;
import GameObjects.Map;
import Interfaces.OpponentInterface;

/**
 *
 * @author Andre
 */
public class AIController implements OpponentInterface 
{
    private Map map;
    
    public AIController(Map map)
    {
        this.map = map;
    }

    @Override
    public Line makeAMove()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

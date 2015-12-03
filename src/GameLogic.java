
import Interfaces.LogicInterface;

/**
 *
 * @author Andre
 */
public class GameLogic implements LogicInterface {
    
    private Map map;
    
    public GameLogic()
    {
        map = new Map(10, 10);        
    }
}


import GameObjects.Line;
import GameObjects.Map;
import GameObjects.Point;
import Interfaces.LogicInterface;
import Interfaces.OpponentInterface;

/**
 *
 * @author Andre
 */
public class GameLogic implements LogicInterface {
    
    private Map map;
    private OpponentInterface opponent;
    
    @Override
    public void initializeGame(int height, int width, OpponentInterface opponent) {
       this.map = new Map(height, width);
       this.opponent = opponent;
    }

    @Override
    public void setLine(Point startPoint, Point endPoint) {
        
        Line line = this.map.getLine(startPoint, endPoint);
        
        //setOwner;
        if(line.getOwner() == null){
            
            
        }
        
        
    }
}

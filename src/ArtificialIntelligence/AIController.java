package ArtificialIntelligence;

import Enums.MessageTypeEnum;
import GameObjects.Line;
import GameObjects.Map;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;

/**
 *
 * @author Andre
 */
public class AIController implements OpponentInterface,SubjectInterface
{
    private Map map;
    private ObserverInterface observer;
    
    public AIController(){
        
    }
    
    public AIController(Map map)
    {
        this.map = map;
    }

    @Override
    public void sendGameInfo(Line selectedLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendGameInfo(MessageTypeEnum msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeMove() {
        
        // hier macht die AI einen pseudozug!!
        
        Line tempLine = new Line(0,0,0,1);
        
        this.observer.makeMove(tempLine, true);
    }


}

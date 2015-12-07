package ArtificialIntelligence;

import Enums.MessageTypeEnum;
import GameObjects.Line;
import GameObjects.Map;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Line tempLine = null;
        
        // hier macht die AI einen pseudozug!!
        int x = new Random().nextInt(9);
        int y = new Random().nextInt(9);
        
        boolean rechts = new Random().nextBoolean();
        
        if(rechts)
        {
            tempLine = new Line(x,y,x + 1, y);
        }
        else
        {
            tempLine = new Line(x,y,x, y+1);
        }
        
         this.observer.makeMove(tempLine, true);
    }
}

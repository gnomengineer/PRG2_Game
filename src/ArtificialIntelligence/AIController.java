package ArtificialIntelligence;

import Enums.MessageTypeEnum;
import GameObjects.Line;
import GameObjects.Map;
import GameObjects.Square;
import Interfaces.LogicInterface;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.SortedMap;
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
    ArrayList<Square> squaresWith0Lines;
    ArrayList<Square> squaresWith1Line;
    ArrayList<Square> squaresWith2Lines;
    ArrayList<Square> squaresWith3Lines;
    
        
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
        
        HashMap<Line,Integer> hashMap = new HashMap<Line,Integer>();
        
        for(int row=0;row < map.getHeight();row++)
        {
            for(int col=0;col<map.getWidth();col++)
            {
                Square s = map.getSquares()[row][col];
                if(!s.getTopLine().isOwned())
                {
                    
                }
                if(!s.getRightLine().isOwned())
                {
                    
                }
                if(!s.getBotLine().isOwned())
                {
                    
                }
                if(!s.getLeftLine().isOwned())
                {
                    
                }
            }
        }
        
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

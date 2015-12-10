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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOpponentTurn() {
        
        //java.util.Map<Line,Integer> hashMap = new HashMap<Line, Integer>();
        ArrayList<LinePriority> lines = new ArrayList<LinePriority>();
        
        for(int row=0;row < map.getHeight();row++)
        {
            for(int col=0;col<map.getWidth();col++)
            {
                Square s = map.getSquares()[row][col];
                for(Line l : s.getLines())
                if(!l.isOwned())
                {
                    int level = s.getNumberOfTakenLines();
                    int priority = 0;
                    if(level == 3)
                    {
                        priority = 1;
                    }
                    if(level == 0)
                    {
                        priority = 2;
                    }
                    if(level == 1)
                    {
                        priority = 3;
                    }
                    if(level == 2)
                    {
                        priority = 4;
                    }
                    lines.add(new LinePriority(l,priority));
                }
            }
        }
        
        Collections.shuffle(lines);
        Collections.sort(lines);
        
        Line l = lines.get(0).getLine();
        
        this.observer.makeMove(l, true);
    }
}

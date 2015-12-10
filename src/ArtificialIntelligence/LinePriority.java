/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

import GameObjects.Line;
import java.util.Comparator;

/**
 *
 * @author Sam
 */
public class LinePriority implements Comparable
{
    private int priority;
    private Line line;

    public LinePriority(Line line,int priority)
    {
        this.priority = priority;
        this.line = line;
    }
    
    @Override
    public int compareTo(Object o)
    {
        LinePriority OtherLine = (LinePriority)o;
        int OtherPriority = OtherLine.priority;
        return this.priority-OtherPriority;
    }

    public Line getLine()
    {
        return this.line;
    }
}

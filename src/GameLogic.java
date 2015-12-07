
import GameObjects.Figur;
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
    private Figur localFigur;
    private Figur opponentFigur;
    
    @Override
    public void initializeGame(int height, int width, OpponentInterface opponent) {
       this.map = new Map(height, width);
       this.opponent = opponent;
       
       localFigur = new Figur(false);
       opponentFigur = new Figur(true);
    }

    @Override
    public void setLine(Point startPoint, Point endPoint, boolean isOpponent) {
        
        Line line = this.map.getLine(startPoint, endPoint);
        
        if(line.getOwner() == null){
            // hier owner setzen
            this.setOwner(line, isOpponent);
            
            // bestimmem, wer am Zug ist!!
            // meine Squares suchen // höchstens 2 und prüfen, ob ich die letzte linie war
            // nun die Punkte setzten, falls es so war, und nun persistieren, dass ich nochmals am zug bin!!
            
            
            // den Opponent informieren, dass er nun am zug ist !            
        }
    }
    
    private void setOwner(Line line, boolean isOpponent){
        if(isOpponent)
        {
            line.setOwner(opponentFigur);
        }
        else
        {
           line.setOwner(localFigur);
        }
        
    }

    @Override
    public void setLine(Line selectedLine, boolean isOpponent) {
        this.setLine(selectedLine.getStartPoint(),selectedLine.getStartPoint(), isOpponent);
    }

    @Override
    public boolean isValidLine(Line selectedLine, boolean isOpponent) {
        Line line = map.getLine(selectedLine.getStartPoint(), selectedLine.getEndPoint());
        return line.getOwner() == null;
    }
}

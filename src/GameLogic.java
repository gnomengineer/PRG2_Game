
import GameObjects.Figur;
import GameObjects.Line;
import GameObjects.Map;
import GameObjects.Point;
import GameObjects.Square;
import Interfaces.LogicInterface;
import Interfaces.OpponentInterface;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class GameLogic implements LogicInterface {
    
    private Map map;
    private OpponentInterface opponent;
    private Figur localFigur;
    private Figur opponentFigur;
    private Figur nextFigur;
    private boolean tempBoolAddedPoints;
    
    @Override
    public void initializeGame(int height, int width, OpponentInterface opponent) {
       this.map = new Map(height, width);
       this.opponent = opponent;
       
       localFigur = new Figur(false);
       opponentFigur = new Figur(true);
    }

    @Override
    public void setLine(Point startPoint, Point endPoint, boolean isOpponent) {
        //Todo
        tempBoolAddedPoints = false;
        
        Line line = this.map.getLine(startPoint, endPoint);
        
        if(line.getOwner() == null){
            // hier owner setzen
            this.setOwner(line, isOpponent);
            
            // bestimmem, wer am Zug ist!!
            // meine Squares suchen // höchstens 2 und prüfen, ob ich die letzte linie war
            // nun die Punkte setzten, falls es so war, und nun persistieren, dass ich nochmals am zug bin!!
            ArrayList<Square> squares =  map.getSquaresBy(line);
            
            squares.forEach(s ->{
                if(s.isTaken() && !s.isOwned())
                {
                    setOwner(s, isOpponent);
                    
                    tempBoolAddedPoints = true;
                }
            });
            
            if(tempBoolAddedPoints)
            {
                //nochmals einen Zug, juhee 
                if(nextFigur == opponentFigur)
                {
                    opponent.setOpponentTurn();
                }
            }
            else
            {
                if(isOpponent)
                {
                    nextFigur = localFigur;
                }
                else
                {
                    nextFigur = opponentFigur;
                    opponent.setOpponentTurn();
                }
            }
                
        }
    }
    
    private void setOwner(Square square, boolean isOpponent)
    {
        if(isOpponent)
                    {
                        square.setOwner(opponentFigur);
                        opponentFigur.incresePoints(1);
                    }
                    else
                    {
                        square.setOwner(localFigur);
                        localFigur.incresePoints(1);
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
        this.setLine(selectedLine.getStartPoint(),selectedLine.getEndPoint(), isOpponent);
    }

    @Override
    public boolean isValidLine(Line selectedLine, boolean isOpponent) {
        Line line = map.getLine(selectedLine.getStartPoint(), selectedLine.getEndPoint());
        return line.getOwner() == null;
    }

    @Override
    public int getPlayerState() {
        return localFigur.getPoints();
    }

    @Override
    public int getOpponentState() {
        return opponentFigur.getPoints();
    }
}

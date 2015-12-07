
import ArtificialIntelligence.AIController;
import Enums.GameModeEnum;
import FactorySet.OpponentFactory;
import GameObjects.Line;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interfaces.*;

/**
 *
 * @author Andre
 */
public class GameController implements ObserverInterface {
    private GameViewInterface gameView;
    private GameOptionsViewInterface gameOptionsView;
    private LogicInterface gameLogic;
    
    public GameController(GameOptionsViewInterface gameOptionsView, GameViewInterface gameView, LogicInterface gameLogic){
        this.gameView = gameView;
        this.gameLogic = gameLogic;
        this.gameOptionsView = gameOptionsView;
    }
    
    public void startControlling(){
        ((SubjectInterface)gameOptionsView).registerObserver(this);
        ((SubjectInterface)gameView).registerObserver(this);

        gameOptionsView.startOptionsView();
    }
  
    private void startGamePreparation() {
        OpponentFactory factory = new OpponentFactory();
        GameModeEnum gameMode = GameModeEnum.AIMode;
        int mapHeight = gameOptionsView.getFieldHeight();
        int mapWidth = gameOptionsView.getFieldWidth();
        
        // damit default immer AI-Mode ist!!
        if(gameOptionsView.getGameMode() != null)
        {
            gameMode= gameOptionsView.getGameMode();
        }
        
        // via Factory erstellen, da ich als Controller den konkretten Opponent nicht kennen will!!
        OpponentInterface opponent =  factory.createOpponent(gameMode);
        
        // damit Controller zu den Spielzügen informiert wird!!
        ((SubjectInterface)opponent).registerObserver(this);
        
        // Logic & View initiieren!!        
        gameLogic.initializeGame(mapHeight, mapWidth, opponent);
        gameView.startGameView(mapWidth, mapWidth);
    }

    @Override
    public void makeMove(Line selectedLine, boolean isOpponent) {
        //DO SOMETHING
        boolean validMove = gameLogic.isValidLine(selectedLine, isOpponent);
        
        if(validMove){
            gameLogic.setLine(selectedLine, isOpponent);
            gameView.drawLine(selectedLine, isOpponent);
        }
    }

    @Override
    public void submitOptions() {
        startGamePreparation();
    }
}

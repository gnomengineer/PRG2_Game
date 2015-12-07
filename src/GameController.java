
import ArtificialIntelligence.AIController;
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
        int mapHeight = 10;
        int mapWidth = 10;
        
        gameLogic.initializeGame(mapHeight, mapWidth, new AIController());
        gameView.startGameView(6, 6);
        
        //this.gameView.drawLine(new Line(1,1,1,2), true);
        //this.gameView.drawLine(new Line(3,3,4,3), false);

    }

    @Override
    public void makeMove(Line selectedLine, boolean isOpponent) {
        //DO SOMETHING
        gameView.drawLine(selectedLine, isOpponent);
    }

    @Override
    public void submitOptions() {
        startGamePreparation();
    }
}

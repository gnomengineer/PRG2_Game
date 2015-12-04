
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
    private ActionListener submitActionListener;
    
    public GameController(GameOptionsViewInterface gameOptionsView, GameViewInterface gameView, LogicInterface gameLogic){
        this.gameView = gameView;
        this.gameLogic = gameLogic;
        this.gameOptionsView = gameOptionsView;
    }
    
    public void StartControlling(){
        ((SubjectInterface)gameOptionsView).registerObserver(this);
        
        gameOptionsView.startOptionsView();
    }
    
    private void startGameSession()
    {
        gameView.startGameView(10,10);
    }
    
    private void startGamePreparation() {
        //Temp for Chief of Gui for testing
        gameView.startGameView(20, 30);
        // do something if needed
        //gameLogic.initializeGame(gameOptionsView.getFieldHeight(), gameOptionsView.getFieldWidth());
    }

    @Override
    public void makeMove(Line selectedLine) {
        //DO SOMETHING
    }

    @Override
    public void submitOptions() {
        //DO SOMETHING
        
        gameView.startGameView(10,10);
    }
}


import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interfaces.*;

/**
 *
 * @author Andre
 */
public class GameController {
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
        initializeListener();
        
        gameOptionsView.registerOptionActionListener(submitActionListener);
        gameOptionsView.startOptionsView();
        
    }
    
    private void startGameSession()
    {
        gameView.startGameView(10,10);
    }
    
    public void initializeListener(){
        submitActionListener = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){               
                startGamePreparation();
            }           
        };
    }
    
    private void startGamePreparation() {
        // do something if needed
        //gameLogic.initializeGame(gameOptionsView.getFieldHeight(), gameOptionsView.getFieldWidth());
    }
}


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
    private ActionListener actionListener;

    
    public GameController(GameOptionsViewInterface gameOptionsView, GameViewInterface gameView, LogicInterface gameLogic){
        this.gameView = gameView;
        this.gameLogic = gameLogic;
        this.gameOptionsView = gameOptionsView;
    }
    
    public void StartControlling(){
        initializeListener();
        
        gameOptionsView.registerOptionActionListener(actionListener);
        gameOptionsView.startOptionsView();
        
    }
    
    private void startGameSession()
    {
        gameView.startGameView(10,10);
    }
    
    public void initializeListener(){
        actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){               
                doSomething();
            }           
        };
    }
    
    private void doSomething() {
        // do something if needed
    }
}

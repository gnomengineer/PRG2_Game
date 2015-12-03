
import Interfaces.GameViewInterface;
import Interfaces.LogicInterface;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andre
 */
public class GameController {
    private GameViewInterface gameView;
    private LogicInterface gameLogic;
    private ActionListener actionListener;

    
    public GameController(GameViewInterface gameView, LogicInterface gameLogic){
        gameView = gameView;
        gameLogic = gameLogic;
    }
    
    public void StartControlling(){
        initializeListener();
        
        gameView.startOptionView();
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

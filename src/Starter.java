
import Views.GameOptionsView;
import Views.GameView;



/**
 *
 * @author Andre
 */
public class Starter{
    public static void main(String[] args)
    {
        System.out.println("Start Application");
                                        
        GameController controller = new GameController(new GameOptionsView(), new GameView(), new GameLogic());
        
        controller.StartControlling();
    }
}

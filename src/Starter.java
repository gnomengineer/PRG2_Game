

/**
 *
 * @author Andre
 */
public class Starter{
    public static void main(String[] args)
    {
        System.out.println("Start Application");
                                        
        GameController controller = new GameController(new GameView(), new GameLogic());
        controller.StartControlling();
        
        
    }
}

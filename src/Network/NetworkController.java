package Network;
import GameObjects.Line;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;
import java.io.IOException;
import Interfaces.NetworkInterface;

/**
 *
 * @author Daniel
 */
public class NetworkController implements OpponentInterface,SubjectInterface{
    NetworkInterface network = null;
    private static final int PORT = 1337;
    ObserverInterface observer = null;
    
    public NetworkController(String hostname) throws IOException{
        network = new Client(PORT, hostname);
        new Thread((Client)network).start();
    }
    
    public NetworkController() throws IOException{
        network = new Server(PORT);
        new Thread((Server)network).start();
    }
    
    @Override
    public void sendLine(Line selectedLine) {
        network.setLine(selectedLine);
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
        network.setObserver(observer);
    }

    @Override
    public void notifyObserver() {
        this.observer.makeMove(network.getLine(), true);
    }

    @Override
    public void setOpponentTurn() {
        System.err.println("WARNING: not used methode - setOpponentTurn() ");
    }

}

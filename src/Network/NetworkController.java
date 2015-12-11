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
    NetworkConnection network = null;
    ObserverInterface observer = null;
    
    public NetworkController(int port, String hostname) throws IOException{
        network = new Client(port, hostname);
        new Thread((Client)network).start();
    }
    
    public NetworkController(int port) throws IOException{
        network = new Server(port);
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
    public void setOpponentTurn() {
        System.err.println("WARNING: not used methode - setOpponentTurn() ");
    }

}

package Network;
import Enums.MessageTypeEnum;
import GameObjects.Line;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;
import java.io.IOException;
import java.net.InetAddress;
import Interfaces.NetworkInterface;

/**
 *
 * @author Andre
 */
public class NetworkController implements OpponentInterface,SubjectInterface{
    NetworkInterface network = null;
    private static final int PORT = 1337;
    ObserverInterface observer = null;
    
    public NetworkController(String hostname) throws IOException{
        network = new Client(PORT, hostname);
    }
    
    public NetworkController() throws IOException{
        network = new Server(PORT);
    }
    
    @Override
    public void sendGameInfo(Line selectedLine) {
        network.setLine(selectedLine);
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    @Override
    public void setOpponentTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

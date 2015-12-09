package Network;
import Enums.MessageTypeEnum;
import GameObjects.Line;
import Interfaces.ObserverInterface;
import Interfaces.OpponentInterface;
import Interfaces.SubjectInterface;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author Andre
 */
public class NetworkController implements OpponentInterface,SubjectInterface{
    Object network = null;
    private static final int PORT = 1337;
    
    public NetworkController(String hostname) throws IOException{
        network = new Client(PORT, hostname);
    }
    
    public NetworkController() throws IOException{
        network = new Server(PORT);
    }
    
    @Override
    public void sendGameInfo(Line selectedLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendGameInfo(MessageTypeEnum msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(ObserverInterface observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

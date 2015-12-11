package Network;

import Enums.MessageTypeEnum;
import Logger.Logger;
import java.io.IOException;
import java.net.Socket;


/**
 * Network client. connects to the server, sends commands to it and receives answers form it.
 *
 * @author Daniel
 */
public class Client extends NetworkConnection {
    
    public Client(int port, String addr) throws IOException{
        Logger.logToConsole(MessageTypeEnum.Debug, "client start");
        Socket socket = new Socket(addr, port);
        
        setSocket(socket);
        start();
    }

}

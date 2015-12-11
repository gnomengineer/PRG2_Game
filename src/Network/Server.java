package Network;

import Enums.MessageTypeEnum;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Logger.Logger;


/**
 * Network server. communicates with the client on both sides.
 *
 * @author Daniel
 */
public class Server extends NetworkConnection implements Runnable{
    ServerSocket server = null;
    
    public Server(int port) throws IOException{
        server = new ServerSocket(port);
        
        //@TODO freezes gui on server side!
        Socket socket = server.accept();
        setSocket(socket);
        start();
    }
}

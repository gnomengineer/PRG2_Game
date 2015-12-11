package Network;

import java.io.IOException;
import java.net.Socket;


/**
 * Network client. connects to the server, sends commands to it and receives answers form it.
 *
 * @author Daniel
 */
public class Client extends NetworkConnection {
    
    public Client(int port, String addr) throws IOException{
        System.out.println("TEST 0");
        Socket socket = new Socket(addr, port);
        
        setSocket(socket);
        System.out.println("TEST 1");
        start();
    }

}

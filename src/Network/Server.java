package Network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Network server. communicates with the client on both sides.
 *
 * @author Daniel
 */
public class Server extends ServerSocket implements Runnable{
    
    
    public Server(int port) throws IOException{
        super(port);
    }

    @Override
    public void run() {
        while(true){
            try{
                Socket clientSocket = accept();
                //new Thread(new Client(clientSocket)).start();
            } catch (IOException ioe){
                //@TODO make a logger
                System.err.println("ERROR: " + ioe.getMessage());
            }
        }
    }

    
    
}

package Network;

import GameObjects.Line;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * Network server. communicates with the client on both sides.
 *
 * @author Daniel
 */
public class Server extends ServerSocket implements Runnable{
    Client client = null;
    
    public Server(int port) throws IOException{
        super(port);
    }

    public void sendPackage(Line line){
        try{
            PrintWriter output = new PrintWriter(client.getOutputStream());
            //output.
        } catch (IOException ioe) {
            
        }
    }
    
    @Override
    public void run() {
        while(true){
            try{
                client = (Client)accept();
            } catch (IOException ioe){
                //@TODO make a logger
                System.err.println("ERROR: " + ioe.getMessage());
            }
        }
    }

    
    
}

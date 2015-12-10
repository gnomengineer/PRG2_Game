package Network;

import GameObjects.Line;
import Interfaces.NetworkInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * Network server. communicates with the client on both sides.
 *
 * @author Daniel
 */
public class Server extends ServerSocket implements Runnable, NetworkInterface{
    Client client = null;
    private Line line = null;
    
    public Server(int port) throws IOException{
        super(port);
    }
    
    @Override
    public void run() {
        while(true){
            try{
                client = (Client)accept();
                new Thread(client).start();
            } catch (IOException ioe){
                //@TODO make a logger
                System.err.println("ERROR: " + ioe.getMessage());
            }
        }
    }

    /**
     * @return the line
     */
    public Line getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Line line) {
        this.line = line;
    }

    
    
}

package Network;

import GameObjects.Line;
import Interfaces.NetworkInterface;
import Interfaces.ObserverInterface;
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
    private ObserverInterface observer = null;
    private Line line = null;
    
    public Server(int port) throws IOException{
        super(port);
    }
    
    /**
     * starts the server accept method and threads the received client.
     * starting a new Thread 
     */
    @Override
    public void run() {
        while(true){
            try{
                client = (Client)accept();
                client.setLine(line);
                client.setObserver(observer);
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

    /**
     * @param observer the observer to set
     */
    public void setObserver(ObserverInterface observer) {
        this.observer = observer;
    }

    
    
}

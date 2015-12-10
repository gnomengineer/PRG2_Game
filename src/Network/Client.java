package Network;

import GameObjects.Line;
import Interfaces.NetworkInterface;
import Interfaces.ObserverInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Network client. connects to the server, sends commands to it and receives answers form it.
 *
 * @author Daniel
 */
public class Client extends Socket implements Runnable, NetworkInterface{
    Line line = null;
    private ObserverInterface observer = null;
    
    public Client(int port, String addr) throws IOException{
        super(addr, port);
    }
    
    /**
     * run method.
     * sends and receives objects from Server-Client-connection
     */
    @Override
    public void run(){
        try(OutputStream out = getOutputStream();
                InputStream in = getInputStream();
                ObjectOutputStream writer = new ObjectOutputStream(out);
                ObjectInputStream reader = new ObjectInputStream(in)){
            while(true){
                if(line != null){
                    writer.writeObject(line);
                }
                Line data = (Line)reader.readObject();
                if(line.equals(data)){
                    observer.makeMove(data, true);
                }
                writer.flush();
            }
        } catch (IOException ioe){
            //@TODO make a logger
            System.err.println("ERROR: " + ioe.getMessage());
        } catch (ClassNotFoundException cex){
            System.err.println("ERROR: " + cex.getMessage());
        }
    }

    @Override
    public void setLine(Line selectedLine) {
        this.line = selectedLine;
    }

    @Override
    public Line getLine() {
        return line;
    }

    /**
     * @param observer the observer to set
     */
    public void setObserver(ObserverInterface observer) {
        this.observer = observer;
    }
    
    

}

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
import javax.management.ObjectInstance;

/**
 *
 * @author Daniel
 */
public class NetworkConnection implements Runnable, NetworkInterface {
    Socket socket = null;
    Line line = null;
    ObserverInterface observer = null;
    
    public NetworkConnection(){
        
    }
    
    public void setSocket(Socket s){
        this.socket = s;
    }
    
    public void start(){
        //Thread t = new Thread(this);
        //t.start();
        run();
    }
    
    /**
     * run method.
     * sends and receives objects from Server-Client-connection
     */
    @Override
    public void run(){
        while(true){
            if(socket == null || !socket.isConnected()){
                System.out.println("ERROR: not connected");
                break;
            }
            try{
                InputStream in = socket.getInputStream();
                ObjectInputStream reader = new ObjectInputStream(in);
                Line data = (Line)reader.readObject();
                observer.makeMove(data, true);
            } catch (IOException ioe){
                System.out.println("ERROR: " + ioe.getMessage());
            } catch (ClassNotFoundException cne){
                System.out.println("ERROR: " + cne.getMessage());
            }
        } 
    }
    
    public void sendDataStream(Line selectedLine){
        if(socket == null || !socket.isConnected()){
            System.out.println("ERROR: not connected");
            return;
        }
        try{
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeObject(selectedLine);
        } catch (IOException ioe){
            System.out.println("ERROR: " + ioe.getMessage());
        }
    }

    /**
     * @param observer the observer to set
     */
    public void setObserver(ObserverInterface observer) {
        this.observer = observer;
    }
}

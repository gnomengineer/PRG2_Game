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
        try(OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                //ObjectOutputStream writer = new ObjectOutputStream(out);
                //ObjectInputStream reader = new ObjectInputStream(in)
            ){
            int i = 0;
            while(true){
                System.out.println(socket.getLocalAddress() + " " + i++);
                /*
                if(line != null){
                    writer.writeObject(line);
                }
                Line data = (Line)reader.readObject();
                if(line.equals(data)){
                    observer.makeMove(data, true);
                }
                writer.flush();
                */
                out.write(i);
                System.out.println("received: " + in.read());
                out.flush();
            }
        } catch (IOException ioe){
            //@TODO make a logger
            System.out.println("ERROR: " + ioe.getMessage());
        } /*catch (ClassNotFoundException cex){
            System.out.println("ERROR: " + cex.getMessage());
        }*/
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

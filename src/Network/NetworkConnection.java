package Network;

import Enums.MessageTypeEnum;
import GameObjects.Line;
import Interfaces.NetworkInterface;
import Interfaces.ObserverInterface;
import Logger.Logger;
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
    
    /**
     * Sets the socket for this class.
     * 
     * @param s 
     */
    public void setSocket(Socket s){
        this.socket = s;
    }
    
    /**
     * starts the Thread.
     */
    public void start(){
        Thread t = new Thread(this);
        t.start();
    }
    
    /**
     * run method.
     * listens on the InputStream and reads the line object. informs the observer
     * about a new line object.
     */
    @Override
    public void run(){
        while(true){
            if(socket == null || !socket.isConnected()){
                Logger.logToConsole(MessageTypeEnum.Warning, "not connected");
                break;
            }
            try{
                InputStream in = socket.getInputStream();
                ObjectInputStream reader = new ObjectInputStream(in);
                Line data = (Line)reader.readObject();
                Logger.logToConsole(MessageTypeEnum.Debug, "object received");
                observer.makeMove(data, true);
            } catch (Exception ioe){
                Logger.logToConsole(MessageTypeEnum.Error, ioe);
            }
        } 
    }
    
    /**
     * sends the Line object to the network opponent.
     * logs an IOException if an error with the stream occured or warning
     * if not correctly connected.
     * 
     * @param selectedLine 
     */
    public void sendDataStream(Line selectedLine){
        if(socket == null || !socket.isConnected()){
            Logger.logToConsole(MessageTypeEnum.Warning, "not connected");
            return;
        }
        try{
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream writer = new ObjectOutputStream(out);
            writer.writeObject(selectedLine);
            Logger.logToConsole(MessageTypeEnum.Debug, "object written");
            writer.flush();
        } catch (IOException ioe){
            Logger.logToConsole(MessageTypeEnum.Error, ioe);
        }
    }

    /**
     * @param observer the observer to set
     */
    public void setObserver(ObserverInterface observer) {
        this.observer = observer;
    }
}

package Network;

import GameObjects.Line;
import Interfaces.NetworkInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Network client. connects to the server, sends commands to it and receives answers form it.
 *
 * @author Daniel
 */
public class Client extends Socket implements Runnable, NetworkInterface{
    Line line = null;
    
    public Client(int port, String addr) throws IOException{
        super(addr, port);
    }
    
    @Override
    public void run(){
        try(OutputStream out = getOutputStream();
                InputStream in = getInputStream()){
            /*int data = in.read();
            while(data != -1){
                out.write(data);
                data = in.read();
            }
            out.flush();*/
            //while true{
            //send line if not null
            //if input not null notify controller
            //}
        } catch (IOException ioe){
            //@TODO make a logger
            System.err.println("ERROR " + ioe.getMessage());
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

}

package Network;

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
public class Client extends Socket implements Runnable{
    private Socket client;
    
    public Client(int port, String addr) throws IOException{
        client = new Socket(addr, port);
    }
    
    @Override
    public void run() {
        while(true){
            try(OutputStream out = client.getOutputStream();
                    InputStream in = client.getInputStream()){
                //do stuff
            } catch (IOException ioe){
                //@TODO make a logger
                System.err.println("ERROR " + ioe.getMessage());
            }    
        }
    }

}

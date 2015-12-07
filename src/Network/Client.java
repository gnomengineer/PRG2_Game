package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Network client. connects to the server, sends commands to it and receives answers form it.
 *
 * @author Daniel
 */
public class Client implements Runnable{
    private Socket client;
    
    public Client(Socket socket){
        client = socket;
    }
    
    @Override
    public void run() {
        try(OutputStream out = client.getOutputStream();
                InputStream in = client.getInputStream()){
            //do stuff
        } catch (IOException ioe){
            //@TODO make a logger
            System.err.println("ERROR " + ioe.getMessage());
        }
    }

}

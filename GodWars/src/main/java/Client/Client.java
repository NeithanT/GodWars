/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Client {
    private final int PORT = 35500;
    private final String IP_ADDRESS = "localhost";
    private Socket socket;
    private FrameClient refFrame;
    //TODO: crear el OBJECT stream
    //TODO: eliminar el data output cuando terminemos lo de objetos
    private DataOutputStream sender;
    private DataInputStream listener;
    private ThreadClient threadClient;

    public Client(FrameClient refFrame) {
        this.refFrame = refFrame;
        this.connect();
        
    }
    
    private void connect (){
        try {
            socket = new Socket(IP_ADDRESS , PORT);
            sender = new DataOutputStream(socket.getOutputStream());    
            listener = new DataInputStream(socket.getInputStream()); 
            
            threadClient =  new ThreadClient(this);
            threadClient.start();
            
            
        } catch (IOException ex) {
            
        }
    }
    
    public void sendString (String msg){
        try {
            sender.writeUTF(msg);
        } catch (IOException ex) {
            
        }
    }  

    public DataOutputStream getSender() {
        return sender;
    }

    public DataInputStream getListener() {
        return listener;
    }

    public FrameClient getRefFrame() {
        return refFrame;
    }
    
    
    
    
    
}

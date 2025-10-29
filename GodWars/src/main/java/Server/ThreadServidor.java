/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

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
public class ThreadServidor extends Thread{
    private Server server;
    private Socket socket;
    //TODO OBJECT
    private DataInputStream listener;
    public DataOutputStream sender;
    
    private boolean isRunning = true;

    public ThreadServidor(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        try {
            listener = new DataInputStream(socket.getInputStream());
            sender =  new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {

        }
    }
    
    public void run (){
        //TODO: pasar a object
        String receivedMessage = "";
        while (isRunning){
            try {
                receivedMessage = listener.readUTF(); //espera hasta recibir un String desde el cliente que tiene su socket
                server.refFrame.writeMessage("ThreadServer recibió: " + receivedMessage);
                server.broadcast(receivedMessage);
                //TODO
                //leer el mensaje, procesarlo ... decidir qué hacer
            } catch (IOException ex) {
                
            }
            
            
            
        }
        
    }
    
    
    
    
    
}

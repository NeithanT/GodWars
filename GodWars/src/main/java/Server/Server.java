package Server;

import Player.Player;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
    private final int PORT = 35500;
    private final int MAX_CONNECTIONS = 4;
    private ArrayList<Player> players;
    private ServerSocket serverSocket;
    
    public Server() {
        System.out.println("Started");
        this.init();
    }
    
    private void init() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println("The port is not avalaible");
        }
    }
    
    public void broadcast(String msg) {
        
    }
    
    public static void main(String[] args) {
    
    }
    
    

    
    
}

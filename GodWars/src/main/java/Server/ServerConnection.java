package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerConnection extends Thread {

    
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    
    private int numOfPlayer;
    public ServerConnection(Socket s, int num) {
        this.socket = s;
        this.numOfPlayer = num;
    }
    
    @Override
    public void run() {
        
        try {
            System.out.println("Problem here:");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            
            outputStream.writeInt(numOfPlayer);
            String inputBuffer = "";
            
            while (!inputBuffer.equals("Over")) {
                System.out.println("Created server Socked");
                try {
                    inputBuffer = inputStream.readUTF();
                    System.out.println(inputBuffer);
                    //outputStream.writeUTF("Hello");
                } catch (IOException ex) {
                    System.out.println("Error sending or input data in SERVER");
                }
            }
            
            
            inputStream.close();
            outputStream.close();
            socket.close();
            
        } catch (IOException ex) {
            System.out.println("Could not connect client");
        }
    }
    
}

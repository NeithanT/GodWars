/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author melissa
 */
import Client.Console.FrameConsole; 
import Server.Client;
import Tiles.Board;

public class CommandContext {
    //referencias útiles para cualquier comando 
    private final FrameConsole console;
    private final Client clientUI;
    private final Board board;

    public CommandContext(FrameConsole console, Client clientUI, Board board) {
        this.console = console;
        this.clientUI = clientUI;
        this.board = board;
    }
    public FrameConsole console(){ return console; }
    public Client client(){ return clientUI; }
    public Board board(){ return board; }
}
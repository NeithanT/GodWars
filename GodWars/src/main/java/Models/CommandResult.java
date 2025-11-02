/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author melissa
 */
public record CommandResult(boolean ok, String message) { // el recoor
    public static CommandResult ok(String msg){ return new CommandResult(true, msg); }
    public static CommandResult fail(String msg){ return new CommandResult(false, msg); }
}

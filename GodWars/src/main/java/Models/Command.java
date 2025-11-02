/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author melissa
 */
public abstract class Command {
    public abstract String name();
    public abstract String help();
    /**
     * Ejecuta el comando en el contexto del cliente (UI + board).
     * Devuelve un CommandResult con mensaje para la consola.
     */
    public abstract CommandResult execute(CommandContext ctx, String[] args);
}

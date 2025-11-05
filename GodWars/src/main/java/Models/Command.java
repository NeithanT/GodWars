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
    public abstract String name(); //nombre del comando
    public abstract String help(); // mensaje corto de ayuda
    
    public abstract CommandResult execute(CommandContext ctx, String[] args); //lógica del comanto 
    //no es serializable, nada viaja por red aún, todo se ejecuta localmente 
}

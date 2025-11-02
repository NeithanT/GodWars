/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author melissa
 */
public class CommandLog extends Command {
    @Override public String name(){ 
        return "LOG";
    }
    @Override public String help(){ 
        return "LOG -> muestra bitácora actual";
    }

    @Override
    public CommandResult execute(CommandContext ctx, String[] args){
        // por ahora solo message informativo; la consola ya contiene todo el historial visible
        return CommandResult.ok("Mostrando bitácora (use el scroll arriba).");
    }
}

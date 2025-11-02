/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author melissa
 */
public class CommandHelp extends Command {
    private final CommandRegistry registry;
    public CommandHelp(CommandRegistry registry){ this.registry = registry; }

    @Override public String name(){ return "HELP"; }
    @Override public String help(){ return "HELP -> lista comandos disponibles"; }

    @Override
    public CommandResult execute(CommandContext ctx, String[] args){
        return CommandResult.ok(registry.helpIndex());
    }    
}

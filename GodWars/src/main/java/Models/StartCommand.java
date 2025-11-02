/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Fighters.FighterType;

/**
 *
 * @author melissa
 */
public class StartCommand extends Command {
    @Override public String name(){ return "START"; }
    @Override public String help(){ return "START -> asigna zonas iniciales y muestra resumen"; }

    @Override
    public CommandResult execute(CommandContext ctx, String[] args){
        try {
            ctx.board().assignZone(FighterType.AQUAMAN,   30);
            ctx.board().assignZone(FighterType.POSEIDON,  20);
            ctx.board().assignZone(FighterType.BLACKMANTA,50);
            return CommandResult.ok("Territorio asignado. " + ctx.board().resumen());
        } catch (Exception ex) {
            return CommandResult.fail("Error en START: " + ex.getMessage());
        }
    }
}

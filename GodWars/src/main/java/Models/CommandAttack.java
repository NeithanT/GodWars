/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Random;

/**
 *
 * @author melissa
 */


public class CommandAttack extends Command {
    private final Random random = new Random();

    public CommandAttack() { }

    @Override public String name(){ return "ATTACK"; }
    @Override public String help(){ return "ATTACK -> envía un ataque aleatorio (10-20)"; }

    @Override
    public CommandResult execute(CommandContext ctx, String[] args){
        try {
            int dmg;
            if (args.length > 0) {
                try { dmg = Integer.parseInt(args[0]); }
                catch(NumberFormatException ex) { dmg = 10 + random.nextInt(11); }
            } else {
                dmg = 10 + random.nextInt(11);
            }

            // envía por la conexión actual (no cambiamos protocolo)
            if (ctx.client() != null && ctx.client().getConnection() != null) {
                ctx.client().getConnection().attack(dmg);
                return CommandResult.ok("Ataque enviado con daño " + dmg);
            } else {
                return CommandResult.fail("Conexión no disponible para enviar ataque.");
            }
        } catch (Exception ex) {
            return CommandResult.fail("Error al ejecutar ATTACK: " + ex.getMessage());
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author melissa
 */
public class CommandRegistry {
    private final Map<String, Command> commands = new LinkedHashMap<>();

    public void register(Command cmd){
        commands.put(cmd.name().toUpperCase(), cmd);
    }

    public Command get(String name){
        if (name == null) return null;
        return commands.get(name.toUpperCase());
    }

    public String helpIndex(){
        StringBuilder sb = new StringBuilder("Comandos disponibles: ");
        for (String k : commands.keySet()) {
            sb.append(k).append("  ");
        }
        return sb.toString().trim();
    }
}

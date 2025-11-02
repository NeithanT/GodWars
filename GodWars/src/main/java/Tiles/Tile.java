package Tiles;

import Fighters.FighterType;
import java.util.ArrayList;
import java.util.List;

public class Tile {
    
    private FighterType owner;  // quién la posee
    private TileState state;
    private int life;           
    private final List<String> history; // historial para guardar td lo que pasa durante el juego, final para que si alguien hace un newAr....

    public Tile() {
        this.state = TileState.EMPTY; 
        this.life = 100;
        this.history = new ArrayList<>();
    }

     public void daño(int cantidad, String atacante) {
        if (life <= 0) return;
        int antes = life;
        life = Math.max(0, life - cantidad);
        if (life == 0) {
            state = TileState.DESTROYED;
        } else {
            state = TileState.DAMAGED;
        }
        this.history.add("Ataque recibido de " + atacante + ": -" + cantidad + ", vida antes: " + antes + ", después:" + life + ":("); //Agregarle talvez que salga la fila y columna de la casilla
    }

    public void heal(int cantidad, String fuente) {
        int antes = life;
        life = Math.min(100, life + cantidad);
        this.history.add("Curación de " + fuente + ": +" + cantidad + ", vida: " + antes + ", después " + life + ":)");
        if (life > 0) {
            this.state = TileState.OCCUPIED;
        }
    }
    
    public FighterType getOwner() {
        return owner;
    }

    public void setOwner(FighterType owner) {
        this.owner = owner;
        this.state = TileState.OCCUPIED;
        this.history.add("Ocupada por: " + owner); //agregarle su ubicación?
    }

    
    public TileState getState() {
        return state;
    }

    public void setState(TileState state) {
        this.state = state;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    
}
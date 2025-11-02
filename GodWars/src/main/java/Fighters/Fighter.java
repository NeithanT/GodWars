package Fighters;

import Tiles.Tile;
import java.util.ArrayList;


public abstract class Fighter {
    
    private FighterType type;
    protected String name;
    protected String imagePath;
    
    protected int representationPercentage; 
    protected ArrayList<Tile> assignedTiles;
    
    private int strength;
    private int endurance;
    private int sanity;
    
    protected boolean strengthActivated; //para próximo ataque
    protected double strengthMultiplier; //1.5, 1.75, 2.0
    
    //TODO; CONSTRUCTOR
    
    
    
    public void addTile(Tile tile) {
        assignedTiles.add(tile);
    }

    public int getAliveTiles() {
        return assignedTiles.size(); //TODO: hacerlo bien
    }

    public int getDeadTiles() {
        return assignedTiles.size() - getAliveTiles();
    }

    public double getLifePercentage() {
        if (assignedTiles.isEmpty()) {
            return 0;
        }
        return (getAliveTiles() * 100.0) / assignedTiles.size();
    }
    
    
    
    public abstract void normalAttack();
    public abstract void specialAttack();
    
}

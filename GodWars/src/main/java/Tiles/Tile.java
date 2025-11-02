package Tiles;

import Fighters.Fighter;


public class Tile {
    
    private int x;
    private int y;
    
    private Fighter fighterInTile;
    
    private double tileLife;
    private boolean alive;
    
    //COSNTRUCTOR

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.fighterInTile = null;
        this.tileLife = 100;
        this.alive = true;
    }
    

}

package Tiles;


public class Board {

    private final int ROWS = 20;
    private final int COLUMNS = 30;
    Tile tiles[][];
    
    public Board() {
        tiles = new Tile[ROWS][COLUMNS];
        initializeTiles();
        
    }
    
    private void initializeTiles() {
    
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
            
                tiles[i][j] = new Tile(i, j);
            }
        }
    }
    
    //distribuir las casillas a cada luchador
    
    
    
    //GETTESR Y SETTERS

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
    
    
    
}

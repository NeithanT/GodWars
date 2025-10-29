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
            for (int j = 0; j < ROWS; j++) {
            
                tiles[i][j] = new Tile();
            }
        }
    }
    
    
}

package Tiles;

import Fighters.FighterType;


public class Board {

    private final int ROWS = 20;
    private final int COLUMNS = 30;
    private Tile[][] tiles;
    
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
    public Tile getTile(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS) return null;
        return tiles[row][col];
    }

    public void assignZone(FighterType fighter, int porcentaje) {
        // Asigna celdas proporcionalmente según el porcentaje del peleador
        int totalTiles = ROWS * COLUMNS;
        int tilesParaAsignar = (int) ((porcentaje / 100.0) * totalTiles);

        int asignados = 0;
        for (int i = 0; i < ROWS && asignados < tilesParaAsignar; i++) {
            for (int j = 0; j < COLUMNS && asignados < tilesParaAsignar; j++) {
                Tile tile = tiles[i][j];
                if (tile.getState() == TileState.EMPTY) {
                    tile.setOwner(fighter);
                    asignados++;
                }
            }
        }
    }

    public String resumen() {
        int occupied = 0, damaged = 0, destroyed = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                switch (tiles[i][j].getState()) {
                    case OCCUPIED -> occupied++;
                    case DAMAGED -> damaged++;
                    case DESTROYED -> destroyed++;
                    default -> {}
                }
            }
        }
        return String.format("Casillas ocupadas: %d | Dañadas: %d | Destruidas: %d", occupied, damaged, destroyed);
    }
}

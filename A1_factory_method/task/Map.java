package A1_factory_method.task;

import java.util.Scanner;

public abstract class Map {
    private Tile[][] tiles = new Tile[5][5];

    abstract Tile createTile(int row, int col);

    //Fills the map
    public Map(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                tiles[i][j] = createTile(i, j);
            }
        }
    }

    public void display(){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

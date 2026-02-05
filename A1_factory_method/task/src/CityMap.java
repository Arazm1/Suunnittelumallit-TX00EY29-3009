package A1_factory_method.task;

public class CityMap extends Map {

    @Override
    Tile createTile(int row, int col){

        if(col == 0 || col == 4){
            return new ForestTile();
        }

        if(col == 1 && row != 2){
            return new BuildingTile();
        }

        if(col == 2 || row == 2 && col != 0 && col != 4){
            return new RoadTile();
        }

        return new ForestTile();
    }
    
}

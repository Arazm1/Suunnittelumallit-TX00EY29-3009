package A1_factory_method.task;

public class WildernessMap extends Map{

    @Override
    Tile createTile(int row, int col) {

        if (row < 2) {
            return new WaterTile();
        }

        if (row == 4) {
            return new SwampTile();
        }

        return new ForestTile();
    }
    
}

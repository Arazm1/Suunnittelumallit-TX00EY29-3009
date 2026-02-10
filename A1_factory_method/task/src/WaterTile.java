package A1_factory_method.task.src;

public class WaterTile implements Tile {

    @Override
    public String getCharacter(){
        return "W";
    }

    @Override
    public String getType(){
        return "water";
    }
}

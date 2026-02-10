package A1_factory_method.task.src;



public class RoadTile implements Tile {

    @Override
    public String getCharacter(){
        return "R";
    }

    @Override
    public String getType(){
        return "road";
    }
    
}

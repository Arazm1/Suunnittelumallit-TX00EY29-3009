package A1_factory_method.task.src;



public class BuildingTile implements Tile {

    @Override
    public String getCharacter(){
        return "B";
    }

    @Override
    public String getType(){
        return "building";
    }
    
}

package A1_factory_method.task;



public class ForestTile implements Tile {
      
    @Override
    public String getCharacter(){
        return "F";
    }

    @Override
    public String getType(){
        return "forest";
    }    
}

public class WildernessMap extends Map{

    @Override
    public Tile createTile(){
        return new ForestTile();
    }

    @Override
    void display(){
        System.out.println(createTile().getCharacter() + " " + createTile().getType());
    }
    
}

public class CityMap extends Map {

    @Override
    Tile createTile(){
        return new RoadTile();
    }

    @Override
    void display(){
        System.out.println(createTile().getCharacter() + " " + createTile().getType());
    }
    
}

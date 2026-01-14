public abstract class Game {

    public void play() {
        Map map = createMap();
        map.display();
    }

    public abstract Map createMap();
    
}

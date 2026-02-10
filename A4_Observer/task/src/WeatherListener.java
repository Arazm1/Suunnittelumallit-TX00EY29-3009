package A4_Observer.task.src;

public class WeatherListener implements Observer {
    private String name;

    public WeatherListener(String name){
        this.name = name;
    }

    @Override
    public void update(String message){
        System.out.println("Sending weather status to " + this.name + ": " + message);
    }
    
}

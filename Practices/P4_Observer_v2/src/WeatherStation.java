import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    private double temperature;

    private final List<Observer> weatherObservers;

    public WeatherStation(double temperature){
        this.temperature = temperature;
        weatherObservers = new ArrayList<>();
    }

    public void registerObserver(Observer observer){
        weatherObservers.add(observer);
    }

    public void removeObserver(Observer observer){
        weatherObservers.remove(observer);
    }

    public void notifyObservers(){
        weatherObservers.forEach(observer -> observer.update(this.temperature));
    }

    public void setTemperature(double newTemperature){
        this.temperature = newTemperature;
        notifyObservers();
    }

    public double getTemperature(){
        return this.temperature;
    }
    
}

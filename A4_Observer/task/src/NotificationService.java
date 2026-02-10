package A4_Observer.task.src;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<WeatherListener> weatherListeners;

    public NotificationService(){
        weatherListeners = new ArrayList<>();
    }

    public void subscribe(WeatherListener listener){
        weatherListeners.add(listener);
    }

    public void unsubscribe(WeatherListener listener){
        weatherListeners.remove(listener);
    }

    public void notifySubscribers(String message){
        weatherListeners.forEach(listener -> listener.update(message));
    }
    
}

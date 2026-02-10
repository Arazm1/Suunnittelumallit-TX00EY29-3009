package A4_Observer.task.src;

import java.util.Random;

public class WeatherStation implements Runnable {
    private NotificationService notificationService;
    private int temperature;
    private final int minTemp = -35;
    private final int maxTemp = 35;
    private Random random = new Random();

    public WeatherStation(){
        notificationService = new NotificationService();
        //initvalue
        this.temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;
    }

    public NotificationService getService(){
        return notificationService;
    }

    private void updateTemperature(){
        //Todo: better algorithm?
        int positiveOrNegative = random.nextBoolean() ? 1 : -1;
        this.temperature += positiveOrNegative;
        if(this.temperature > maxTemp){
            this.temperature = maxTemp;
        }
        if(this.temperature < minTemp){
            this.temperature = minTemp;
        }
    }

    @Override
    public void run(){
        while(true){
            try{
                System.out.println("Updating temperature");
                updateTemperature();
                notificationService.notifySubscribers("Current temperature: " + this.temperature + "°C");
                int delay = random.nextInt(5) + 1;
                Thread.sleep(delay * 1000);

            }
            catch(InterruptedException e){
                System.out.println("Error: " + e);
            }
            catch(Error e){
                System.out.println("Error: " + e);
            }
            //finally{
            //    System.out.println("Program finished.");
            //}
        }
    }


    /*
    public void newWeatherStatus(){
        notificationService.notifySubscribers("new status!");
    }
    */

    
    
}

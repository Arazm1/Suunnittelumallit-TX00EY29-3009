public class Main {

    public static void main(String[] args) {
        
        //System.out.println("4");

        WeatherStation weatherStation = new WeatherStation();

        WeatherListener user1 = new WeatherListener("User1");
        WeatherListener user2 = new WeatherListener("User2");

        weatherStation.getService().subscribe(user1);
        weatherStation.getService().subscribe(user2);

        //weatherStation.newWeatherStatus();
        Thread thread = new Thread(weatherStation);
        thread.start();



    }
    
}

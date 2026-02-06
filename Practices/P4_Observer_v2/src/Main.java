public class Main {

    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation(0);
        //weatherStation.getTemperature();
        System.out.println(weatherStation.getTemperature());

        WeatherListener phone = new WeatherListener("Phone");
        WeatherListener laptop = new WeatherListener("Laptop");


        weatherStation.registerObserver(laptop);
        weatherStation.registerObserver(phone);

        weatherStation.setTemperature(25.0);
    }
     
}

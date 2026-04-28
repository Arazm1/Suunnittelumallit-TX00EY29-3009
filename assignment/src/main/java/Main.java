import java.io.IOException;
import java.util.Scanner;

import subsystems.HttpHandler;
import subsystems.IHttpHandler;
import subsystems.IJsonParser;
import subsystems.JsonParser;

public class Main {

    private static String chuckNorrisAPI = "https://api.chucknorris.io/jokes/random";
    private static String chuckNorrisValue = "value";

    private static String randomJokeAPI = "https://official-joke-api.appspot.com/random_joke";
    private static String randomJokeValue = "setup";

    private static String catFactAPI = "https://catfact.ninja/fact";
    private static String catFactValue = "fact";

    private static IHttpHandler httpHandler = new HttpHandler();
    private static IJsonParser jsonParser = new JsonParser();
    private static APIFacade apiFacade = new APIFacade(httpHandler, jsonParser);

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        while(true){
            Menu();
            int userChoice = scanner.nextInt();

            switch(userChoice) {
                case 1 -> request(chuckNorrisAPI, chuckNorrisValue);
                case 2 -> request(randomJokeAPI, randomJokeValue);
                case 3 -> request(catFactAPI, catFactValue);
                case 4 -> {
                    return;
                }
                default -> {
                    break;
                }       
            }
        }
    }

    public static void Menu(){
        System.out.println("------------------------");
        System.out.println("1. Chuck Norris joke");
        System.out.println("2. Random joke");
        System.out.println("3. Cat fact");
        System.out.println("4. EXIT");
        System.out.println("------------------------");
    }

    public static void request(String API, String value) {
        try {
            String response = apiFacade.getAttributeValueFromJson(API, value);
            System.out.println(response + "\n");
        } catch (IOException e) {
            System.out.println("Request failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Attribute not found: " + e.getMessage());
        }
    }
    
}

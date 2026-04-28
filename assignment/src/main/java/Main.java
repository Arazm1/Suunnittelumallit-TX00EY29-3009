import java.io.IOException;

import subsystems.HttpHandler;
import subsystems.IHttpHandler;
import subsystems.IJsonParser;
import subsystems.JsonParser;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException, IOException {
        
        IHttpHandler httpHandler = new HttpHandler();
        IJsonParser jsonParser = new JsonParser();

        APIFacade apiFacade = new APIFacade(httpHandler, jsonParser);

        String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random");
        System.out.println(joke);
    }
    
}

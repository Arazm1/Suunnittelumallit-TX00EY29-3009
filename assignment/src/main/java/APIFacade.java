import java.io.IOException;

import subsystems.IHttpHandler;
import subsystems.IJsonParser;

public class APIFacade {

    private IHttpHandler httpHandler;
    private IJsonParser jsonParser;

    public APIFacade(IHttpHandler httpHandler, IJsonParser jsonParser){
        this.httpHandler = httpHandler;
        this.jsonParser = jsonParser;
    }

    public String getAttributeValueFromJson(String urlString) throws IllegalArgumentException, IOException {
        String json = httpHandler.getJsonFromAPI(urlString);   // was getJsonFromApi()
        return jsonParser.extractJokeFromJson(json); // was extractJokeFromJson()
    }
    
}

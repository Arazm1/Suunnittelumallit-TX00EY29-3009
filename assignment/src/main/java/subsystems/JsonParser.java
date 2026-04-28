package subsystems;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser implements IJsonParser{

    @Override
    public String extractJokeFromJson(String json) throws IllegalArgumentException{
        try{
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            return (String) jsonObject.get("value");
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }

    
    
}

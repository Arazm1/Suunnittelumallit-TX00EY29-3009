package subsystems;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser implements IJsonParser{

    @Override
    public String extractFromJson(String json, String attributeName) throws IllegalArgumentException{
        try{
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            return (String) jsonObject.get(attributeName);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Failed to parse JSON: " + e.getMessage());
        }
        
    }

    
    
}

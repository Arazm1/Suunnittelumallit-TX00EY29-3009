package subsystems;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//3
public interface IJsonParser {
    String extractFromJson(String json, String attributeName) throws IllegalArgumentException;
    
}

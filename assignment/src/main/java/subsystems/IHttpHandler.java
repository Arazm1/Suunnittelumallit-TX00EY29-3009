package subsystems;

import java.io.IOException;

//1
public interface IHttpHandler {
    String getJsonFromAPI(String apiUrl) throws IOException;
    
    
}

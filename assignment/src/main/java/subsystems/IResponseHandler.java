package subsystems;

import java.io.IOException;
import java.net.HttpURLConnection;

//2
public interface IResponseHandler {
    void validate(HttpURLConnection connection) throws IOException;
    
}

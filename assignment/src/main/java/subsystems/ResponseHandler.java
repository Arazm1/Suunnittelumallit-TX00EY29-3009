package subsystems;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ResponseHandler implements IResponseHandler{

    @Override
    public void validate(HttpURLConnection connection) throws IOException{
        int statusCode = connection.getResponseCode();
        if(statusCode != HttpURLConnection.HTTP_OK){
            throw new IOException("HTTP Request failed with status code: " + statusCode);
        }
    }
    
}

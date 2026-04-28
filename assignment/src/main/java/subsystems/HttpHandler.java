package subsystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler implements IHttpHandler{

    private IResponseHandler responseHandler;

    public HttpHandler(){
        this.responseHandler = new ResponseHandler();
    }

    @Override
    public String getJsonFromAPI(String apiUrl) throws IOException{
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        responseHandler.validate(con);

        try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))){
            String inputLine;
            StringBuilder content = new StringBuilder();
            while((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            return content.toString();
        }
        finally{
            con.disconnect();
        }
    }
}

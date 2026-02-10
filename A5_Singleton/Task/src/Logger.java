package A5_Singleton.Task.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter bw;
    private String filename;

    private final String defaultPath = "A5_Singleton/Task/file/";
    private final String defaultFile = "defaultfile.txt";

    private Logger(){
        setFilename(defaultFile);
    }


    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }



    public synchronized void setFilename(String newFile){
        try{
            close();
            this.filename = newFile;
            bw = new BufferedWriter(new FileWriter(defaultPath + newFile, true));
            
            System.out.println("setFilename - successful");
        }
        catch(IOException e){
            System.out.println("Error in setFilename: " + e);
        }
    }

    public synchronized void write(String text){
        try{
            if(bw != null){
                bw.write(text);
                bw.newLine();
                bw.flush();

                System.out.println("Write - successful");
            }
        }
        catch(IOException e){
            System.out.println("Error in write: " + e);
        }
    }

    public synchronized void close(){
        try{
            if(bw != null){
                bw.close();
                bw = null;

                System.out.println("close - successful");
            }

            //System.out.println("close (try block) - unsuccessful");
        }
        catch(IOException e){
            System.out.println("Error in close: " + e);
        }
        
    }

    public synchronized String getFilename(){
        return this.filename;
    }
    
}

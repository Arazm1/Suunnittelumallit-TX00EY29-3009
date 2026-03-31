package A12_Proxy.task.src;

import java.time.LocalDate;

public class RealDocument implements Document {

    private int ID;
    private LocalDate date;
    private String content;

    public RealDocument(int ID, LocalDate date, String content){
        this.ID = ID;
        this.date = date;
        this.content = content;
    }

    @Override
    public int getID(){
        return this.ID;
    }

    @Override
    public LocalDate getDate(){
        return this.date;
    }

    @Override
    public String getContent(User user){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }    
}

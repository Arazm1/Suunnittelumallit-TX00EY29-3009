import java.time.LocalDateTime;

public class Memento implements IMemento{
    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected){
        this.options = options.clone(); //Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
        this.timestamp = LocalDateTime.now();
    }

    public int[] getOptions(){
        return this.options;
    }

    public boolean isSelected(){
        return this.isSelected;
    }

    public LocalDateTime getTimeStamp(){
        return this.timestamp; 
    }

    @Override
    public String toString(){
        return "State saved at: " + timestamp.toString();
    }
    
}

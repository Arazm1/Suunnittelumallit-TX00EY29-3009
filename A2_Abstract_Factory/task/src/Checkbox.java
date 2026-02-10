package A2_Abstract_Factory.task.src;

public abstract class Checkbox {

    protected String text;

    public Checkbox(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    abstract void display();
    
}

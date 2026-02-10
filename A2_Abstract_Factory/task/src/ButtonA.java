package A2_Abstract_Factory.task.src;

public class ButtonA extends Button{

    public ButtonA(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("Button-A: " + text);
    }
    
}

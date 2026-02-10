package A2_Abstract_Factory.task.src;

public class ButtonB extends Button{

    public ButtonB(String text){
        super(text);
    }
    
    @Override
    public void display(){
        System.out.println("Button-B:" + text);
    }
}

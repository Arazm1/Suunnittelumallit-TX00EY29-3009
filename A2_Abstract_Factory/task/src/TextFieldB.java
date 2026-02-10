package A2_Abstract_Factory.task.src;

public class TextFieldB extends TextField{

    public TextFieldB(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("TextField-B: " + text);
    }
}

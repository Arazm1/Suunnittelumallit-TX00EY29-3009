package A2_Abstract_Factory;

public class TextFieldA extends TextField {


    public TextFieldA(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("TextField-A");
    }
    
}

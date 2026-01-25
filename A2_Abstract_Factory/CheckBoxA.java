package A2_Abstract_Factory;

public class CheckBoxA extends Checkbox{

    public CheckBoxA(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("CheckBox-A: " + text);
    }   
}

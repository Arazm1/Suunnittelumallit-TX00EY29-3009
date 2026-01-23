package A2_Abstract_Factory;

public class CheckBoxB extends Checkbox{

    public CheckBoxB(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("CheckBox-B");
    }
    
}

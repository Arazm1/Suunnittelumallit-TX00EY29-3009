package A2_Abstract_Factory.task.src;

public class AFactory extends UIFactory{

    public Button createButton(String text){
        return new ButtonA(text);
    }

    public TextField createTextField(String text){
        return new TextFieldA(text);
    }

    public Checkbox createCheckbox(String text){
        return new CheckBoxA(text);
    }
}

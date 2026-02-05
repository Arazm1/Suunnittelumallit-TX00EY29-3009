package A2_Abstract_Factory;


public abstract class UIFactory {

    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);

    
    
}

package A2_Abstract_Factory;

public class Main {

    public static void main(String[] args) {
        UIFactory uiFactory = new AFactory();

        Button button = uiFactory.createButton("OK");
        TextField textField = uiFactory.createTextField("username");
        Checkbox checkbox = uiFactory.createCheckbox("order");

        button.display();
        textField.display();
        checkbox.display();

        button.setText("Cancel");
        textField.setText("password");
        checkbox.setText("refund");

        button.display();
        textField.display();
        checkbox.display();
        
    }
    
}

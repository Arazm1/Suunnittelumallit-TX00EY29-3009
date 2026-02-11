package A6_Decorator.Task.src;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer){
        super(printer);
    }

    @Override
    public void print(String text){
        //Todo: Functionality
        super.print(text.toUpperCase());
    }
    
}

package A6_Decorator.Task.src;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer){
        super(printer);
    }

    @Override
    public void print(String text){
        //Todo: Functionality
        super.print(text.toUpperCase());
    }
    
}

package A6_Decorator.Task.src;

public class XMLPrinter extends PrinterDecorator {

    private String XMLTag1;
    private String XMLTag2;

    public XMLPrinter(Printer printer){
        super(printer);
        this.XMLTag1 = "<message>";
        this.XMLTag2 = "</message>"; 
    }

    @Override
    public void print(String text){
        //Todo: Functionality
        super.print(this.XMLTag1 + text + this.XMLTag2);
    }
    
}

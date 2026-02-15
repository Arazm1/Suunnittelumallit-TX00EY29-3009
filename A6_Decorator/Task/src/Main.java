package A6_Decorator.Task.src;

public class Main {
    public static void main(String[] args) {
        

        Printer printer;
        printer = new BasicPrinter();
        printer.print("Hello World!");

        printer = new XMLPrinter(new BasicPrinter());
        printer.print("hello world");

        printer = new EncryptedPrinter(new BasicPrinter());
        printer.print("hello world");

    }
    
}

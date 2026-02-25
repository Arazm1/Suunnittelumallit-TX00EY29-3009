package A6_Decorator.Task.src;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
        

        Printer printer;
        printer = new BasicPrinter();
        printer.print("Hello World!");

        printer = new XMLPrinter(new BasicPrinter());
        printer.print("hello world");

        printer = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer.print("Hello World!");




        EncryptedPrinter ep = new EncryptedPrinter(new BasicPrinter());

        String encrypted = ep.encrypt("Hello World!");
        System.out.println("Encrypted: " + encrypted);

        String decrypted = ep.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

    }
    
}

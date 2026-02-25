package A6_Decorator.Task.src;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
        

        Printer printer;
        printer = new BasicPrinter();
        printer.print("Hello World!");

        printer = new XMLPrinter(new BasicPrinter());
        printer.print("hello world");

        EncryptedPrinter encryptedPrinter = new EncryptedPrinter(new BasicPrinter());

        String encrypted = encryptedPrinter.encryptDecrypt("Hello World", Cipher.ENCRYPT_MODE);
        encryptedPrinter.print("Hello World");
        encryptedPrinter.print(encrypted);


        //encryptedPrinter.print("hello world");
        //String encryptedText = encryptedPrinter.encryptDecrypt("hello world", Cipher.ENCRYPT_MODE);
        //encryptedPrinter.print(encryptedText);

    }
    
}

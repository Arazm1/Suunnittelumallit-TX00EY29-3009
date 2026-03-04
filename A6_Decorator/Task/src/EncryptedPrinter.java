package A6_Decorator.Task.src;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    private final SecretKey secretKey;
    private final String algorithm;
    private boolean encrypted;
    

    public EncryptedPrinter(Printer printer){
        super(printer);
        this.algorithm = "AES";
        this.encrypted = false;
        this.secretKey = generateKey();
    }


    public static SecretKey generateKey(){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecretKey key = keyGenerator.generateKey();
            return key;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public String encrypt(String text){
        try{
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
            byte[] result = cipher.doFinal(text.getBytes());
            return Base64.getEncoder().encodeToString(result);
        }
        catch(Exception e){
            return null;
        }
    }


    public String decrypt(String text){
        try{
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(text);
            byte[] result = cipher.doFinal(decodedBytes);
            return new String(result);
        }
        catch(Exception e){
            return null;
        }

    }


    @Override
    public void print(String text){
        String encryptedText = encrypt(text);
        super.print(encryptedText);
    }
    
}

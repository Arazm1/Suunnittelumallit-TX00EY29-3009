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

    public String encryptDecrypt(String text, int mode){
        try{
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(mode, this.secretKey);

            if(mode == Cipher.DECRYPT_MODE){
                byte[] decodedBytes = Base64.getDecoder().decode(text);
                byte[] result = cipher.doFinal(decodedBytes);
                return new String(result);
            }
            else{
                byte[] result = cipher.doFinal(text.getBytes());
                return Base64.getEncoder().encodeToString(result);
            }
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public void print(String text){
        if(!encrypted){
            text = encryptDecrypt(text, Cipher.ENCRYPT_MODE);
            encrypted = true;
        }
        else{
            text = encryptDecrypt(text, Cipher.DECRYPT_MODE);
            encrypted = false;
        }

        super.print(text);
    }
    
}

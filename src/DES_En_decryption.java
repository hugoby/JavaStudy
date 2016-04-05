import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2016/4/4 20:28
 */
public class DES_En_decryption {
    private final static String DES = "DES";

    public static void main(String[]args) throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, IOException {
        byte[]key=initSecretKey();
        final String key2=Base64.toBase64String(key);

        final String text="Hugo";
        final byte[] text_temp=text.getBytes();

        String encryptString= Base64.toBase64String(DES_encrypt(text_temp,key));


        String decryptString=DES_decrypt(DES_encrypt(text_temp,key),key);


        System.out.println("Before encryption:  "+text);
        System.out.println("Length_text:  " + text.length()+' '+text_temp.length);
        System.out.println("Length_string:  "+encryptString.length());
        System.out.println("After encryption:   "+encryptString);
        System.out.println("After decryption:  "+decryptString);
    }

    private static byte[] initSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator kg=KeyGenerator.getInstance(DES);
        kg.init(56);
        SecretKey secretKey=kg.generateKey();
        return secretKey.getEncoded();
    }

    public static byte[] DES_encrypt(byte[] src,byte[]key) throws InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {
        SecureRandom sr=new SecureRandom();
        DESKeySpec desKeySpec=new DESKeySpec(key);
        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance(DES);
        SecretKey securekey=keyFactory.generateSecret(desKeySpec);

        Cipher cipher=Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE,securekey,sr);
        return cipher.doFinal(src);
    }

    /*
    public final static String DES_encrypt(String password,String key){
        try{
            return byte2String(DES_encrypt(password.getBytes(),key.getBytes()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String byte2String(byte[]b){
        String hs="";
        String stmp="";
        for(int n=0;n<b.length;n++){
            stmp=(java.lang.Integer.toHexString(b[n]&0xFF));
            if(stmp.length()==1)
                hs+=hs+"0"+stmp;
            else
                hs=hs+stmp;
        }
        return hs.toUpperCase();
    }
    */

    public static String DES_decrypt(byte[] src, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return new String(cipher.doFinal(src));
    }

    /*
    public final static String DES_decrypt(String data, String key) {
        try {
            return new String(DES_decrypt(String2byte2(data.getBytes()), key.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] String2byte2(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("length isn't odd");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
    */
}

package remotemanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cooper
 */
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class CryptUtil {

    private static final String KEY = "EvaM931i5tCa1ha5";

    public static String md5Hex(String text)
      throws NoSuchAlgorithmException
    {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(text.getBytes());
      byte[] digest = m.digest();
      BigInteger bigInt = new BigInteger(1, digest);
      String hashtext = bigInt.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    }

    public static String encrypt(String data) throws Exception {
      Key key = new SecretKeySpec("EvaM931i5tCa1ha5".getBytes(), "AES");
      Cipher c = Cipher.getInstance("AES");
      c.init(1, key);
      byte[] encVal = c.doFinal(data.getBytes());
      return new BASE64Encoder().encode(encVal);
    }

    public static String decrypt(String encryptedData) throws Exception {
      Key key = new SecretKeySpec("EvaM931i5tCa1ha5".getBytes(), "AES");
      Cipher c = Cipher.getInstance("AES");
      c.init(2, key);
      byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
      return new String(c.doFinal(decordedValue));
    }
    public static void main(String[] args) throws Exception {

        System.out.println(encrypt("evam123"));
        System.out.println(decrypt("VVtSqTGWiLngVSTGGfWnCw=="));
        System.out.println(md5Hex("Em_Pmon_1040as"));

    }
}

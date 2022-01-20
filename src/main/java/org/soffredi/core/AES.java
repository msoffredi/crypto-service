package org.soffredi.core;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * I imported and adapted this class from: 
 * https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
 */
public class AES {
 
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    public static void setKey(
        String myKey
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest sha = null;
        key = myKey.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16); 
        secretKey = new SecretKeySpec(key, "AES");
    }
 
    /**
     * Encrypts using AES
     * 
     * @param strToEncrypt
     * @param secret
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(
        String strToEncrypt,
        String secret
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException,
            NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            UnsupportedEncodingException, IllegalBlockSizeException {
        
        setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }
 
    public static String decrypt(
        String strToDecrypt,
        String secret
    ) throws NoSuchAlgorithmException, UnsupportedEncodingException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException {
        
        setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
}

package org.soffredi.core;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Encrypts and decrypts using AES algorithm and a provided key
 * 
 * Imported and adapted from: 
 * https://howtodoinjava.com/java/java-security/java-aes-encryption-example/
 */
public class AES {
    private static SecretKeySpec secretKey;
    private static byte[] key;
 
    private static void setKey(
        String myKey
    ) throws Exception {

        MessageDigest sha = null;
        key = myKey.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16); 
        secretKey = new SecretKeySpec(key, "AES");
    }
 
    /**
     * Encrypts a string with a provided key
     * 
     * @param strToEncrypt string to encrypt
     * @param secret encryption key
     * @return encrypted string
     * @throws Exception 
     */
    public static String encrypt(
        String strToEncrypt,
        String secret
    ) throws Exception {
        
        setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }
 
    /**
     * Descrypts an AES encrypted string using a provided key
     * 
     * @param strToDecrypt encrypted string to decrypt
     * @param secret decryption key
     * @return decrypted string
     * @throws Exception
     */
    public static String decrypt(
        String strToDecrypt,
        String secret
    ) throws Exception {
        
        setKey(secret);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
}

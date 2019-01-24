package com.app.common;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.app.exception.AlgorithmException;

public class AESProvider {
	private static final String KEYSTRING = "";
	private static SecretKeySpec secretKey ;
    private static byte[] key ;
    
    private static String decryptedString;
    private static String encryptedString;
    
    static {
    	setKey(KEYSTRING);
    }
    
    private static void setKey(String myKey){
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            
        } catch (Exception e) {
        	
        	throw new AlgorithmException(e);
        	
        } 
    
    }
    
    public static String getDecryptedString() {
        return decryptedString;
    }
    
    public static void setDecryptedString(String decryptedString) {
        AESProvider.decryptedString = decryptedString;
    }
    
    public static String getEncryptedString() {
        return encryptedString;
    }
    
    public static void setEncryptedString(String encryptedString) {
        AESProvider.encryptedString = encryptedString;
    }
    
    public static String encrypt(String strToEncrypt) {
        try {
        	Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
            
        } catch (Exception e) {
        	throw new AlgorithmException(e);
        }
        return encryptedString;
    }
    
    public static String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
            
        } catch (Exception e) {
        	throw new AlgorithmException(e);
        }
        return decryptedString;
    }
}	

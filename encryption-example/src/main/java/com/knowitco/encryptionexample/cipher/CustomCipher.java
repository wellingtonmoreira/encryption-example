package com.knowitco.encryptionexample.cipher;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CustomCipher {
	
	public static byte[] encryptAES(byte[] key, byte[] message) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
			 {
	
		Cipher cipher;
		
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		}
		
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
		
		return cipher.doFinal(message);
	}
	
	public static byte[] decryptAES(byte[] key, byte[] message) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		
		Cipher cipher;
		
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		}
		
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
		
		return cipher.doFinal(message);
	}
}

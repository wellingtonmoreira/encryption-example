package com.knowitco.encryptionexample;

import java.security.InvalidKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.knowitco.encryptionexample.cipher.CustomCipher;
import com.knowitco.encryptionexample.model.Person;
import com.knowitco.encryptionexample.model.Person.Gender;

public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    	String key = "3A20ADD8FBD2467F";
    	Person person = new Person("Wellington", "Moreira", "Fake Avenue, 23 - Fakeville - FK", "1-800-FAKE", Gender.MALE, format.parse("08/07/1992"));
    	
    	try {
			byte[] encrypted = CustomCipher.encryptAES(key.getBytes(), person.getBytes());
			System.out.println("Person instance after encryption:\n" + new String(encrypted));
			for(int i = 0; i < encrypted.length; i++) {
				System.out.print(encrypted[i]+", ");
			}
			
			byte[] decrypted = CustomCipher.decryptAES(key.getBytes(), encrypted);
			System.out.println("Person instance after decryption:\n" + new String(decrypted));
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
    }
}

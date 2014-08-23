package com.knowitco.encryption_example.cipher;

import static org.junit.Assert.assertEquals;

import java.security.InvalidKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.junit.Before;
import org.junit.Test;

import com.knowitco.encryptionexample.cipher.CustomCipher;
import com.knowitco.encryptionexample.model.Person;
import com.knowitco.encryptionexample.model.Person.Gender;

public class CustomCipherTest {

	private String key;
	private Person person;
	private byte[] encrypted;
	
	@Before
	public void setUp() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		byte[] encryptedAux = {-28, 79, -120, -92, 70, 8, -12, 108, -83, 66, 40, -67, -109, 118, 94, 28, -69, -103, 6, -10, -29, 27, 74, -92, -76, -96, -41, 15, 5, 67, -4, -92, 27, -26, -114, -72, -100, 120, -101, 23, -65, 36, 89, 5, -74, -80, 64, -22, -89, -100, 87, 100, 5, 54, 22, -65, 115, 54, -69, -75, -51, 39, -80, -112, 40, 78, -105, -42, -123, -102, -10, 102, 122, 27, 70, -79, -116, -51, -77, 100, -2, 96, 0, -21, 44, 8, 75, -9, 35, 117, -94, -78, -51, -40, 104, -108, 110, -95, -87, 39, -26, 116, -2, 91, 3, -72, 89, -84, -68, -78, 73, -61, 107, 87, 36, 37, 26, 106, -117, 32, -119, 84, -51, -100, -78, -125, -81, -81, -78, -97, -124, -14, 39, -41, 52, -43, 37, -114, 98, -88, 74, 85, 102, -29};
		
		key = "70A954FB54EACADF";
		
		encrypted = encryptedAux;
		try {
			person = new Person("Judy", "Foo", "1923 Foo Ave. - Fooland - FO", "1-800-FOO", Gender.FEMALE, format.parse("10/10/1980") );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void encryptAESSuccess() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException  {
		byte[] result = CustomCipher.encryptAES(key.getBytes(), person.getBytes());
		
		assertEquals(new String(encrypted), new String(result));
	}
	
	@Test(expected = InvalidKeyException.class)
	public void encryptAESErrorKey() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException  {
		CustomCipher.encryptAES("ENCRYPTIONISGREAT".getBytes(), person.getBytes());
	}
	
	@Test
	public void decryptAESSuccess() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		String result = new String(CustomCipher.decryptAES(key.getBytes(), encrypted));
		
		assertEquals(person.toString(), result);
	}
	
	@Test(expected = InvalidKeyException.class)
	public void decryptAESErrorKey() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		CustomCipher.decryptAES("DECRYPTIONISALSOGREAT".getBytes(), person.getBytes());
	}
	
	@Test(expected = IllegalBlockSizeException.class)
	public void decryptAESErrorBlockSize() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		CustomCipher.decryptAES(key.getBytes(), "WhAt aM i 0rd3r1ng t0 b3 d3crypt3d?".getBytes());
	}
	
	@Test(expected = BadPaddingException.class)
	public void decryptAESErrorBadPadding() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		CustomCipher.decryptAES(key.getBytes(), "TO EVALUATE THIS EXCEPTION I MUST PROVIDE A MULTIPLE OF 16 KEY..".getBytes());
	}
	
}

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;


public class AESTest {
   //https://yangyag.tistory.com/467
  private static String sKeyString = "" ;
  private static String message= "This is just an example";

  public static void main(String[] args) {
	    // 1. 128 비트 비밀키 생성
	    KeyGenerator kgen = null;
		try {
			kgen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    kgen.init(128);
	    SecretKey skey = kgen.generateKey();

	    // 2. 비밀 키를 이렇게 저장하여 사용하면 암호화/복호화가 편해진다.
	    sKeyString = Hex.encodeHexString(skey.getEncoded());

	    // 3. 암호화 수행
	    SecretKeySpec skeySpec = new SecretKeySpec(skey.getEncoded(), "AES");

	    Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    byte[] encrypted = null;
		try {
			encrypted = cipher.doFinal(message.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    System.out.println("encrypted string: " + Hex.encodeHexString(encrypted));

	    // 4. 복호화 수행
	    try {
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    byte[] original = null;
		try {
			original = cipher.doFinal(encrypted);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String originalString = new String(original);
	    System.out.println("Original string: " + originalString + " " + Hex.encodeHexString(original));
  }
  

}



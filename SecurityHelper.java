import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SecurityHelper {
	private static String sKeyString = "mySecretHaHaHa";
	private Cipher mCipher;

	public SecurityHelper() {
		super();

		mCipher = null;
		try {
			mCipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//https://yangyag.tistory.com/467
	public String doEncrypt(String input) {
		SecretKeySpec mSKeySpec = new SecretKeySpec(returnKey().getBytes(), "AES");
		try {
			mCipher.init(Cipher.ENCRYPT_MODE, mSKeySpec);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] encrypted = null;
		try {
			encrypted = mCipher.doFinal(input.getBytes());
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		Encoder encoder = Base64.getEncoder();
		byte[] encodedBytes = encoder.encode(encrypted);
		 */
		System.out.println("encrypted string: " + Hex.encodeHexString(encrypted));
		
		return Hex.encodeHexString(encrypted);
	}

	public String doDecrypt(String input) {
		byte[] decodedBytes = null;
		
		try {
			decodedBytes = Hex.decodeHex(input.toCharArray());
		} catch (DecoderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SecretKeySpec mSKeySpec = new SecretKeySpec(returnKey().getBytes(), "AES");
		// 4. 복호화 수행
		try {
			mCipher.init(Cipher.DECRYPT_MODE, mSKeySpec);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] original = null;
		try {
			original = mCipher.doFinal(decodedBytes);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String originalString = new String(original);
		System.out.println("Original string: " + originalString + " " + Hex.encodeHexString(original));
		return originalString;
	}

	private static String returnKey() {
		return sKeyString + "on";
	}
	
	/*
	public static void main(String[] args) {
		SecurityHelper sm = new SecurityHelper();
		sm.doDecrypt(sm.doEncrypt("123411"));
	}
	*/
}

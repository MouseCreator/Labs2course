package Structure;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LogPassword {
	private static final int iterations = 6556;
	public static boolean validatePassword(String password, String expected) {
		
		try {
			String[] parts = expected.split(":");
			byte[] salt = fromHex(parts[0]);
			byte[] hash = fromHex(parts[1]);
			byte[] testHash = getHash(password, salt);
		
			if (hash.length != testHash.length)
				return false;
			
			int difference = 0;
			for (int i = 0; i < hash.length; i++) {
				difference |= hash[i] ^ testHash[i];
			}
			
			return difference == 0;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	private static byte[] fromHex(String hex)throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for(int i = 0; i < bytes.length ;i++)
	    {
	        bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return bytes;
	}
	private static byte[] getHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, 512);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		return skf.generateSecret(spec).getEncoded();
	}
	public static String hashPassword(String password) {
		try {
			byte[] salt = getSalt();
			byte[] hash = getHash(password, salt);
			return toHex(salt) + ":" + toHex(hash);
		} catch(Exception e) {
			System.err.print(e.getMessage());
			return null;
		}
		
	}
	
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
	
	private static String toHex(byte[] arr) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, arr);
		String hex = bi.toString(16);
		
		int paddingLength = (arr.length * 2) - hex.length();
		
		return paddingLength > 0 ? String.format("%0" + paddingLength + "d", 0) + hex : hex;
	}
}

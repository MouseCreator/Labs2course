package lab2d;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.Test;

import Structure.LogPassword;
import Structure.LoginPasswordPair;
import Structure.PasswordReader;

class LogPasswordTest {

	@Test
	void testPasswordStorage() {
		String password = "password";
		String hashed = LogPassword.hashPassword(password);
		String[] failAttempts = {"hello", "1234", "pass", "password1", "pAssWord"};
		String success = "password";
		
		for (String s : failAttempts) {
			assertFalse(LogPassword.validatePassword(s, hashed));
		}
		assertTrue(LogPassword.validatePassword(success, hashed));
	}
	
	@Test
	void scannerTest() {
		LoginPasswordPair pair = PasswordReader.getFromFile("Misha");
		assertFalse(pair.empty());
	}

}

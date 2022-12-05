package Structure;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;
public class PasswordReader {
	private static String EXTENTION = ".txt";
	public static LoginPasswordPair getFromFile(String login) {
		try {
			File file = new File("src/Sources/Passwords" + EXTENTION);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] loginPassword = line.split("\t");
				if (loginPassword[0].equals(login)) {
					scanner.close();
					return new LoginPasswordPair(loginPassword[0], loginPassword[1]);
				}
			}
			scanner.close();
			return new LoginPasswordPair();
			}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return new LoginPasswordPair();
		}
	}
	
	public static String loadInfo(String login) {
		try {
			File file = new File("src/Sources/" + login + EXTENTION);
			try (Scanner scanner = new Scanner(file)) {
				String result = "";
				if (scanner.hasNextLong()) {
					long seed = Long.parseLong(scanner.nextLine());
					Random r = new Random(seed);
					while (scanner.hasNext()) {
						char c = scanner.findInLine(".").charAt(0);
						result += (char)(c ^ r.nextInt(512));
					}
				}
				return result;
			}
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return "";
		}
	}
	
	public static void saveInfo(String login, String info) {
		try {
			FileWriter writer = new FileWriter("src/Sources/" + login + EXTENTION);
			Random r = new Random();
			long seed = r.nextLong();
			r = new Random(seed);
			writer.write(seed + "\n");
			for (char c : info.toCharArray()) {
				writer.write((char)(c ^ r.nextInt(512)));
			}
			writer.close();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

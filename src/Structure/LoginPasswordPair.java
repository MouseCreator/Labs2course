package Structure;

public class LoginPasswordPair {
	public String password ;
	public String username ;
	public LoginPasswordPair(String username, String password) {
		this.password = password;
		this.username = username;
	}
	public LoginPasswordPair() {
		this.password = null;
		this.username = null;
	}
	public boolean empty() {
		return this.username == null || this.password == null;
	}
}

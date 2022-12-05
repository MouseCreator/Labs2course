package Structure;

import 	java.util.HashMap;

public class UserAndPassword {
	private HashMap<String, String> logininfo = new HashMap<String, String>();
	
	public UserAndPassword() {
		logininfo.put("Misha", "1234");
	}
	
	protected HashMap<String, String> getLoginInfo() {
		return logininfo;
	}
}

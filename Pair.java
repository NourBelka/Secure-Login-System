import java.util.ArrayList;
import java.util.List;
public class Pair <T1,T2> {
	
	private T1 username;
	private T2 password;

	public Pair(T1 username, T2 password) {
		this.username = username;
		this.password = password;
		
	}
	

	//Getters
	public T1 getUsername() {
		return username;
	}
	public T2 getPassword() {
		return password;
	}
	
	
	//Static inner class
	static class PasswordRules {
		
		static int minChar = 8;
		
		 public static boolean isStrongPassword(String password) {
			
			boolean hasUpperCase = false;
			boolean hasLowerCase = false;
			boolean hasDigit = false;
			
			for (int i=0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) 
					 hasUpperCase = true;
				else if (Character.isLowerCase(c)) 
					 hasLowerCase = true;
				else if (Character.isDigit(c))
					 hasDigit = true;
				
			}
			return (hasUpperCase && hasLowerCase && hasDigit && (password.length() >= minChar));
				
		}
		
	}
	
	
	
	

}

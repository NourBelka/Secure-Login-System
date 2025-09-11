import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	//Non-static inner class
		class LoginLogger {
			
			List<String> message = new ArrayList <>();
			
			public void log(String username, boolean success) {
				if (success)
					message.add("User: " + username + " - SUCCESS");
				else
					message.add("User: " + username + " - FAILURE");
			}
		
			public void printLog() {
				System.out.println("Login log:");
				for(String m : message)
				System.out.println(m);

			}			
		}

	static 	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		final int register = 1;
		final int login = 2;
		Main outer = new Main();
		LoginLogger logger = outer.new LoginLogger();
		ArrayList <Pair<String, String>> accounts = new ArrayList <>();
		
		System.out.println("Welcome to SecureLoginSystem");
		
		while(true) {
		System.out.print("Do you want to (1) Register or (2) Login? ");
		int answer = scanner.nextInt();		
		
		if (answer == register) {
			System.out.print("Enter username: ");
			String username = scanner.next();
			
			System.out.print("Enter password: ");
			String password = scanner.next();
			Pair<String, String> user = new Pair(username, password);

			if(Pair.PasswordRules.isStrongPassword(password)) {
				accounts.add(user);
				System.out.println("\nRegistration Successful!\n");
			}
			else {
				System.out.println("Invalid password. Registration Failed.\n");
			}
		}
		
		else if(answer == login) {
			System.out.print("Enter username: ");
			String username = scanner.next();
			
			System.out.print("Enter password: ");
			String password = scanner.next();
			
			//Security Check
			SecurityCheck security = new SecurityCheck() {
			public boolean pass() {
				int x = (int)(Math.random() * 10);
				int y = (int)(Math.random() * 10);
				System.out.print("Security Check: What is " + x + " + " + y + "? ");
				int answer = scanner.nextInt();
				return answer == (x + y);
				}
			};
			
			if (!security.pass()) {
				System.out.println("Security check failed. Login denied.");
				return;
			}
			
			boolean loginSuccess = false;

			for (Pair<String, String> a : accounts) {
				if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
					loginSuccess = true;
					break;
				}
			}

			if (loginSuccess) {
				System.out.println("Login successful!\n");
				logger.log(username, true);
			} else {
				System.out.println("Login failed.\n");
				logger.log(username, false);
			}
			
			logger.printLog();
			break;
			}
			
		}
		scanner.close();
	}
}

interface SecurityCheck {
	boolean pass();
}


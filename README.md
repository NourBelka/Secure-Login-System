# Secure-Login-System

A Java-based console application that simulates a secure login and registration system using inner classes. This project demonstrates the use of static, non-static, and anonymous inner classes to manage user accounts and enforce security rules.

---

## Features

- Stores username-password pairs using a generic `Pair<String>` class in an `ArrayList`.
- Validates password strength with a **static inner class** (`PasswordRules`).
- Logs login attempts with a **non-static inner class** (`LoginLogger`).
- Uses an **anonymous inner class** for a one-time security challenge during login.
- Provides a simple console menu for registration and login.

---

## How It Works

1. **Registration**
   - Prompts for username and password.
   - Validates password (minimum 8 characters, at least one uppercase, one lowercase, and one number).
   - Stores valid accounts in an `ArrayList<Pair<String>>`.

2. **Login**
   - Prompts for username and password.
   - Runs a one-time security challenge (e.g., math question) via an anonymous inner class.
   - Verifies credentials against stored accounts.
   - Logs the result (success or failure) using `LoginLogger`.

3. **Logging**
   - At the end of the program, prints a log of all login attempts.
  
---

## How to Run

1. Clone the repository.
2. Open the project in your Java IDE (e.g., IntelliJ, Eclipse).
3. Run the Main.java file.
4. Follow the prompts to register or log in.

---

## Sample Interaction

```text
Welcome to SecureLoginSystem Do you want to (1) Register or (2) Login? 1 
Enter username: alice 
Enter password: Demotime3 
Registration successful!

Do you want to (1) Register or (2) Login? 2 
Enter username: alice 
Enter password: Demotime3 
Security Check: What is 3 + 5? 8 
Login successful!

Login Log: User: alice - SUCCESS

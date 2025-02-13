package pkg1;
import java.util.*;
public class user_login {
    
    protected static String name;
    protected static long phonenumber;
    Scanner sc = new Scanner(System.in);

    void display() {
        try {
            System.out.println("Enter your name for login: ");
            String username = sc.nextLine();

            System.out.println("Enter your phone number: ");
            while (!sc.hasNextLong()) {
                System.out.println("Invalid input. Please enter a valid phone number.");
                sc.next(); 
            }
            long number = sc.nextLong();
            sc.nextLine(); 

            this.name = username;
            this.phonenumber = number;

            System.out.println("..............You are logged in successfully!...............");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
    }

    void process() {
        try {
            if (name == null || name.isEmpty()) {
                System.out.println("Login required before proceeding to rental process.");
                return;
            }
            System.out.println(name + " : Welcome to Rental process. Please follow the instructions");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error during process: " + e.getMessage());
        }
    }
}
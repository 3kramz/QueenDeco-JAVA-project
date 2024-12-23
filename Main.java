import java.util.Scanner;
import models.User;
import services.AdminService;
import services.AuthenticationService;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = getValidChoice(scanner, 1, 3);

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = AuthenticationService.authenticate(username, password);
                    if (user != null) {
                        System.out.println("Login successful. Welcome " + user.getName());
                        if ("admin".equals(user.getRole())) {
                            adminMenu(scanner);
                        } else {
                            customerMenu(scanner, user);
                        }
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;



                case 2:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    boolean success = AuthenticationService.registerUser(newUsername, newPassword, "customer", name, address, phone, email);
                    if (success) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;

                   case 3:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Please enter a valid choice between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                scanner.nextLine();  // Consume the invalid input
            }
        }
        return choice;
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Registered Customers");
            System.out.println("2. Add Inventory Item");
            System.out.println("3. View Inventory");
            System.out.println("4. View Booked Items");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice = getValidChoice(scanner, 1, 5);  // Admin menu range 1-5

            switch (choice) {
                case 1:
                    AdminService.viewRegisteredCustomers();
                    break;

                
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void customerMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Book Item");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
        
        }
    }
}

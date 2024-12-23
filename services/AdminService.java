package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.User;

public class AdminService {

    private static Map<String, User> users = AuthenticationService.getUsers();
    private static List<String> inventory = new ArrayList<>();


    // Admin: View all registered customers
    public static void viewRegisteredCustomers() {
        System.out.println("\n--- Registered Customers ---");
        for (User user : users.values()) {
            if ("customer".equals(user.getRole())) {
                System.out.println("Username: " + user.getUsername() +
                        ", Name: " + user.getName() +
                        ", Address: " + user.getAddress() +
                        ", Phone: " + user.getPhone() +
                        ", Email: " + user.getEmail());
            }
        }
    }


    public static void addInventoryItem(String item) {
        inventory.add(item);
        System.out.println("Inventory Item Added: " + item);
    }


    public static void viewInventory() {
        System.out.println("\n--- Inventory ---");
        for (String item : inventory) {
            System.out.println(item);
        }
    }



}

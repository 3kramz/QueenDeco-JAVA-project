package services;

import models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminService {

    private static Map<String, User> users = AuthenticationService.getUsers();


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



}

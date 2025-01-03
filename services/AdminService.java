package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.User;

public class AdminService {

    private static Map<String, User> users = AuthenticationService.getUsers();
    private static List<String> inventory = new ArrayList<>();
    private static List<String> bookedItems = new ArrayList<>();


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


    public static void bookItem(String item, String customerName, String address, String phone) {
        bookedItems.add("Item: " + item + " | Customer: " + customerName + " | Address: " + address + " | Phone: " + phone);
        System.out.println("Booking successful! Item: " + item + ", Customer: " + customerName);
    }


        public static void viewBookings() {
        System.out.println("\n--- Booked Items ---");
        for (String booking : bookedItems) {
            System.out.println(booking);
        }
    }



}

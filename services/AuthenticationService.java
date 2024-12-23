package services;


import java.util.HashMap;
import java.util.Map;
import models.User;



public class AuthenticationService {
    private static Map<String, User> users = new HashMap<>();

    static {
        // Pre-register an admin user
        users.put("admin", new User("admin", "admin123", "admin", "Admin User", "Admin Address", "1234567890", "admin@domain.com"));
    }


    public static User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Successful login
        }
        return null; // Invalid credentials
    }

        public static boolean registerUser(String username, String password, String role, String name, String address, String phone, String email) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, new User(username, password, role, name, address, phone, email));
        return true; // Successfully registered
    }

     public static Map<String, User> getUsers() {
        return users;
    }
}

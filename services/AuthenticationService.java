package services;


import models.User;
import java.util.HashMap;
import java.util.Map;



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
}

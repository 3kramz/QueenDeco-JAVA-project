package models;

public class User {
    private String username;
    private String password;
    private String role;
    private String name;
    private String address;
    private String phone;
    private String email;

    public User(String username, String password, String role, String name, String address, String phone, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

package com.example.springwithsql.Entity;

import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long userID;
    public String username;
    public String password;
    @OneToMany(mappedBy = "user")
    private List<UserRole> roles;
    public boolean enabled;
    public int age;

    public User(){
        this.userID = 0;
        this.age = 0;
        this.username = "NULL";
        this.password = "NULL";
    }


    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public static String HashPassword(String input){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return input;
        }
    }

    public long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getAge() {
        return age;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

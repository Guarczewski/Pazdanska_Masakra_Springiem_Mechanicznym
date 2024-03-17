package com.example.springwithsql.Entity;

import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userID;
    public String name;
    public String password;
    public int age;

    public User(){
        this.userID = 0;
        this.age = 0;
        this.name = "NULL";
        this.password = "NULL";
    }


    public User(String name, String password, int age) {
        this.name = name;
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

}

package com.example.springwithsql.Auth.Models;

public class LoginModel{
    String inUsername;
    String inPassword;
    public LoginModel(){
        inUsername = "NULL";
        inPassword = "NULL";
    }

    public LoginModel(String inUsername, String inPassword) {
        this.inUsername = inUsername;
        this.inPassword = inPassword;
    }

    public String getInUsername() {
        return inUsername;
    }

    public void setInUsername(String inUsername) {
        this.inUsername = inUsername;
    }

    public String getInPassword() {
        return inPassword;
    }

    public void setInPassword(String inPassword) {
        this.inPassword = inPassword;
    }
}

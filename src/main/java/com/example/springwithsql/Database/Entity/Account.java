package com.example.springwithsql.Database.Entity;

import com.example.springwithsql.Database.Entity.Person;
import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String username;
    protected String password;
    protected String roles;
    @OneToOne
    protected Person details;
    public Account() {
    }
    public Account(String username, String password, String roles, Person details) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.details = details;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Person getDetails() {
        return details;
    }

    public void setDetails(Person details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", details=" + details +
                '}';
    }
}


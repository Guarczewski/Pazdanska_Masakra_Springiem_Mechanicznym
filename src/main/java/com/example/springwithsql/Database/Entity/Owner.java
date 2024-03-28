package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int clientID;
    protected String name;
    protected String surname;
    protected String phoneNumber;
    protected String emailAddress;
    @ManyToOne
    @JoinColumn(name = "addressID")
    protected Address address;

    public Owner(){}

    public Owner(String name, String surname, String phoneNumber, String emailAddress, Address address) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public int getPersonID() {
        return clientID;
    }

    public void setPersonID(int personID) {
        this.clientID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}


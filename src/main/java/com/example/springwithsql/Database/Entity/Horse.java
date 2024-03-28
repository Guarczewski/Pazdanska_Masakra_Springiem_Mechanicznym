package com.example.springwithsql.Database.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String name;
    protected String race;
    protected String ointment;
    protected String fatherName;
    protected String motherName;
    protected String description;
    protected LocalDate birthDate;

    public Horse() {}

    public Horse(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
